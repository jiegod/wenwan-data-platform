package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.common.enums.SqlType;
import com.wenwan.common.exception.BusinessException;
import com.wenwan.mysql.dao.entity.*;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.parse.ParseTaskService;
import com.wenwan.service.util.AsyncExecutor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ParseTaskServiceImpl extends MapperConfigService implements ParseTaskService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    // todo 目前只实现全量加载，后续必须实现增量，需要记录游标
    @Override
    public void incrParse() {

    }

    @Override
    public void fullParse(String fileType) {
        LambdaQueryWrapper<BusinessLog> wrapper = Wrappers.lambdaQuery(BusinessLog.class)
                .eq(BusinessLog::getLoadingStatus,1)
                .eq(BusinessLog::getTableStatus,1)
                .eq(BusinessLog::getParseStatus,0)
                .eq(BusinessLog::getFileType,fileType);
        List<BusinessLog> businessLogs = businessLogMapper.selectList(wrapper);
        List<Future<?>> futures = businessLogs.stream().map(businessLog -> parseTableThreadPool.submit(() -> parseTask(businessLog))).collect(Collectors.toList());
        AsyncExecutor.wait(futures);
    }

    @Override
    public void parseTask(BusinessLog businessLog) {
        LambdaQueryWrapper<TaskGroup> wrapper = Wrappers.lambdaQuery(TaskGroup.class)
                .eq(TaskGroup::getParseRuleId,businessLog.getParseRuleId());
        List<TaskGroup> taskGroups = taskGroupMapper.selectList(wrapper);
        for (TaskGroup taskGroup : taskGroups) {
            LambdaQueryWrapper<TaskSql> w = Wrappers.lambdaQuery(TaskSql.class)
                    .eq(TaskSql::getTaskGroupId,taskGroup.getId())
                    .eq(TaskSql::getStatus,0);
            List<TaskSql> taskSqls = taskSqlMapper.selectList(w);

            pre(taskSqls,businessLog);

            etl(taskSqls,businessLog);

            post(taskSqls,businessLog);
        }

    }

    private void pre(List<TaskSql> taskSqls, BusinessLog businessLog) {
        taskSqls.stream().filter(p -> SqlType.PRE.equals(p.getType())).sorted(Comparator.comparing(TaskSql::getPriority)).forEach(p->{
            if(!executeSql(p, businessLog)){
                preError(taskSqls,businessLog);
            }
        });
    }

    private void etl(List<TaskSql> taskSqls, BusinessLog fileId) {
        taskSqls.stream().filter(p -> SqlType.ETL.equals(p.getType())).sorted(Comparator.comparing(TaskSql::getPriority)).forEach(p->{
            if(!executeSql(p, fileId)){
                preError(taskSqls,fileId);
            }
        });
        updateParseStatus(fileId,1);
    }

    private void post(List<TaskSql> taskSqls, BusinessLog fileId){
        taskSqls.stream().filter(p -> SqlType.POST.equals(p.getType())).sorted(Comparator.comparing(TaskSql::getPriority)).forEach(p->{
            executeSql(p, fileId);
        });
        updateParseStatus(fileId,3);
    }

    private void preError(List<TaskSql> taskSqls, BusinessLog businessLog) {
        taskSqls.stream().filter(p-> SqlType.PRE_ERROR.equals(p.getType())).sorted(Comparator.comparing(TaskSql::getPriority)).forEach(p->{
            executeSql(p, businessLog);
        });
        updateParseStatus(businessLog,2);
        throw new BusinessException("parse task fail:"+businessLog.getFileId());
    }

    private void updateParseStatus(BusinessLog businessLog, int status) {
        businessLog.setParseStatus(status);
        businessLogMapper.updateById(businessLog);
    }

    private boolean executeSql(TaskSql taskSql, BusinessLog businessLog) {
        LambdaQueryWrapper<TaskSqlParam> wrapper = Wrappers.lambdaQuery(TaskSqlParam.class)
                .eq(TaskSqlParam::getTaskSqlId,taskSql.getId());
        List<TaskSqlParam> taskSqlParams = taskSqlParamMapper.selectList(wrapper);
        Map<Integer, List<TaskSqlParam>> map = taskSqlParams.stream().collect(Collectors.groupingBy(TaskSqlParam::getGroup));
        String sql = taskSql.getContent();
        sql=sql.replace("&{FILE_ID}",businessLog.getFileId()+"");
        for (Map.Entry<Integer, List<TaskSqlParam>> entry : map.entrySet()) {
            String subSql=sql;
            for (TaskSqlParam taskSqlParam : entry.getValue()) {
                subSql=subSql.replace("${"+taskSqlParam.getKey()+"}",taskSqlParam.getValue());
            }
            Long startTime=System.currentTimeMillis();
            try {
                //todo 配置Oracle 存储过程 （call存储过程）
                sqlSessionTemplate.getConnection().createStatement().execute(subSql);
                Long endTime=System.currentTimeMillis();
                insertSqlLog(taskSql,businessLog,0,null,endTime-startTime);
            } catch (SQLException e) {
                Long endTime=System.currentTimeMillis();
                insertSqlLog(taskSql,businessLog,1,e,endTime-startTime);
                return false;
            }
        }
        return true;
    }

    private void insertSqlLog(TaskSql taskSql, BusinessLog businessLog, int status, SQLException e, long costTime){
        SqlLog sqlLog=new SqlLog();
        sqlLog.setParseRuleId(businessLog.getParseRuleId());
        sqlLog.setParseRuleCode(businessLog.getParseRuleCode());
        sqlLog.setFileId(businessLog.getFileId());
        sqlLog.setTaskGroupId(taskSql.getTaskGroupId());
        sqlLog.setTaskGroupCode(taskSql.getTaskGroupCode());
        sqlLog.setTaskSqlId(taskSql.getId());
        sqlLog.setTaskSqlCode(taskSql.getCode());
        sqlLog.setType(taskSql.getType());
        sqlLog.setPriority(taskSql.getPriority());
        sqlLog.setStatus(status);
        sqlLog.setCostTime(costTime);
        if(e!=null){
            sqlLog.setError(e.getMessage());
        }
        sqlLogMapper.insert(sqlLog);
    }


}
