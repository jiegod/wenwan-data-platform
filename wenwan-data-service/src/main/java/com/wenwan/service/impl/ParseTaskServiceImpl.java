package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.common.enums.SqlType;
import com.wenwan.common.exception.BusinessException;
import com.wenwan.mysql.dao.entity.*;
import com.wenwan.oracle.dao.StorageMapper;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.parse.ParseTaskService;
import com.wenwan.service.util.AsyncExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ParseTaskServiceImpl extends MapperConfigService implements ParseTaskService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    private StorageMapper storageMapper;

    @Value("${oracle.flag:false}")
    private boolean oracleFlag;

    // todo 目前只实现全量加载，后续必须实现增量，需要记录游标
    @Override
    public void incrParse() {

    }

    @Override
    public void parseTask(String parseRuleCode, Long fileId, Long parseRuleId) {
        LambdaQueryWrapper<TaskGroup> wrapper = Wrappers.lambdaQuery(TaskGroup.class)
                .eq(TaskGroup::getParseRuleId, parseRuleId);
        List<TaskGroup> taskGroups = taskGroupMapper.selectList(wrapper);
        for (TaskGroup taskGroup : taskGroups) {
            LambdaQueryWrapper<TaskSql> w = Wrappers.lambdaQuery(TaskSql.class)
                    .eq(TaskSql::getTaskGroupId, taskGroup.getId())
                    .eq(TaskSql::getStatus, 0);
            List<TaskSql> taskSqls = taskSqlMapper.selectList(w);

            pre(taskSqls, parseRuleCode, fileId, parseRuleId);

            etl(taskSqls, parseRuleCode, fileId, parseRuleId);

            post(taskSqls, parseRuleCode, fileId, parseRuleId);
        }

    }

    @Override
    public void cnsjFullParse() {
        while (true) {
            BusinessLogCnsj businessLog = cnsjMapper.getUnStartParseTaskOneRow();
            if (businessLog == null) {
                return;
            }
            try {
                LambdaUpdateWrapper<BusinessLogCnsj> wrapper = Wrappers.lambdaUpdate(BusinessLogCnsj.class)
                        .set(BusinessLog::getParseStatus, 1)
                        .eq(BusinessLog::getId, businessLog.getId());
                cnsjMapper.update(null, wrapper);
                parseTask(businessLog.getParseRuleCode(), businessLog.getFileId(), businessLog.getParseRuleId());
                LambdaUpdateWrapper<BusinessLogCnsj> success = Wrappers.lambdaUpdate(BusinessLogCnsj.class)
                        .set(BusinessLog::getParseStatus, 2)
                        .eq(BusinessLog::getId, businessLog.getId());
                cnsjMapper.update(null, success);
            } catch (Exception e) {
                log.error("cnsjFullParse error.", e);
                LambdaUpdateWrapper<BusinessLogCnsj> wrapper = Wrappers.lambdaUpdate(BusinessLogCnsj.class)
                        .set(BusinessLog::getParseStatus, 3)
                        .eq(BusinessLog::getId, businessLog.getId());
                cnsjMapper.update(null, wrapper);
            }
        }
    }

    @Override
    public void cwjzFullParse() {

    }

    @Override
    public void cwqrdFullParse() {

    }

    @Override
    public void cwyspFullParse() {

    }

    @Override
    public void dwbzjFullParse() {

    }

    @Override
    public void dzdFullParse() {

    }

    private void pre(List<TaskSql> taskSqls, String parseRuleCode, Long fileId, Long parseRuleId) {
        taskSqls.stream().filter(p -> SqlType.PRE.equals(p.getType())).sorted(Comparator.comparing(TaskSql::getPriority)).forEach(p -> {
            if (!executeSql(p, parseRuleCode, fileId, parseRuleId)) {
                preError(taskSqls, parseRuleCode, fileId, parseRuleId);
            }
        });
    }

    private void etl(List<TaskSql> taskSqls, String parseRuleCode, Long fileId, Long parseRuleId) {
        taskSqls.stream().filter(p -> SqlType.ETL.equals(p.getType())).sorted(Comparator.comparing(TaskSql::getPriority)).forEach(p -> {
            if (!executeSql(p, parseRuleCode, fileId, parseRuleId)) {
                preError(taskSqls, parseRuleCode, fileId, parseRuleId);
            }
        });
    }

    private void post(List<TaskSql> taskSqls, String parseRuleCode, Long fileId, Long parseRuleId) {
        taskSqls.stream().filter(p -> SqlType.POST.equals(p.getType())).sorted(Comparator.comparing(TaskSql::getPriority)).forEach(p -> {
            executeSql(p, parseRuleCode, fileId, parseRuleId);
        });
    }

    private void preError(List<TaskSql> taskSqls, String parseRuleCode, Long fileId, Long parseRuleId) {
        taskSqls.stream().filter(p -> SqlType.PRE_ERROR.equals(p.getType())).sorted(Comparator.comparing(TaskSql::getPriority)).forEach(p -> {
            executeSql(p, parseRuleCode, fileId, parseRuleId);
        });
        throw new BusinessException("parse task fail:" + fileId);
    }


    private boolean executeSql(TaskSql taskSql, String parseRuleCode, Long fileId, Long parseRuleId) {
        LambdaQueryWrapper<TaskSqlParam> wrapper = Wrappers.lambdaQuery(TaskSqlParam.class)
                .eq(TaskSqlParam::getTaskSqlId, taskSql.getId());
        List<TaskSqlParam> taskSqlParams = taskSqlParamMapper.selectList(wrapper);
        String sql = taskSql.getContent();
        if (CollectionUtils.isEmpty(taskSqlParams)) {
            sql = sql.replace("&{FILE_ID}", String.valueOf(fileId));
            executeSql(taskSql, sql, parseRuleCode, fileId, parseRuleId);
        } else {
            Map<Integer, List<TaskSqlParam>> map = taskSqlParams.stream().collect(Collectors.groupingBy(TaskSqlParam::getGroup));
            sql = sql.replace("&{FILE_ID}", String.valueOf(fileId));
            for (Map.Entry<Integer, List<TaskSqlParam>> entry : map.entrySet()) {
                String subSql = sql;
                for (TaskSqlParam taskSqlParam : entry.getValue()) {
                    subSql = subSql.replace("${" + taskSqlParam.getKey() + "}", taskSqlParam.getValue());
                    executeSql(taskSql, sql, parseRuleCode, fileId, parseRuleId);
                }
            }
        }
        return true;
    }

    private boolean executeSql(TaskSql sql, String subSql, String parseRuleCode, Long fileId, Long parseRuleId) {
        Long startTime = System.currentTimeMillis();
        try {
            if (oracleFlag && (subSql.contains("call ") || subSql.contains("CALL "))) {
                storageMapper.execStorage(subSql);
            } else {
                jdbcTemplate.execute(subSql);
            }
            Long endTime = System.currentTimeMillis();
            insertSqlLog(sql, fileId, parseRuleId, parseRuleCode, 0, null, endTime - startTime);
        } catch (Exception e) {
            Long endTime = System.currentTimeMillis();
            insertSqlLog(sql, fileId, parseRuleId, parseRuleCode, 1, e, endTime - startTime);
            return false;
        }
        return true;
    }

    private void insertSqlLog(TaskSql taskSql, Long fileId, Long parseRuleId, String parseRuleCode, int status, Exception e, long costTime) {
        SqlLog sqlLog = new SqlLog();
        sqlLog.setParseRuleId(parseRuleId);
        sqlLog.setParseRuleCode(parseRuleCode);
        sqlLog.setFileId(fileId);
        sqlLog.setTaskGroupId(taskSql.getTaskGroupId());
        sqlLog.setTaskGroupCode(taskSql.getTaskGroupCode());
        sqlLog.setTaskSqlId(taskSql.getId());
        sqlLog.setTaskSqlCode(taskSql.getCode());
        sqlLog.setType(taskSql.getType());
        sqlLog.setPriority(taskSql.getPriority());
        sqlLog.setStatus(status);
        sqlLog.setCostTime(costTime);
        if (e != null) {
            sqlLog.setError(e.getMessage());
        }
        sqlLogMapper.insert(sqlLog);
    }


}
