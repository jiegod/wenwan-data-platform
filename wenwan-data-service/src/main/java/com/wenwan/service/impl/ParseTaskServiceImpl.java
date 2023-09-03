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
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class ParseTaskServiceImpl extends MapperConfigService implements ParseTaskService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    private StorageMapper storageMapper;

    @Value("${oracle.flag:false}")
    private boolean oracleFlag;

    private static final ExecutorService targetTableThreadPool = Executors.newFixedThreadPool(10);

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
    public void fullParse(String param) {
        if (StringUtils.isEmpty(param)) {
            targetTableThreadPool.submit(this::cnsjFullParse);
            targetTableThreadPool.submit(this::cwjzFullParse);
            targetTableThreadPool.submit(this::cwqrdFullParse);
            targetTableThreadPool.submit(this::cwyspFullParse);
            targetTableThreadPool.submit(this::dwbzjFullParse);
            targetTableThreadPool.submit(this::dzdFullParse);
        } else {
            if ("cnsj".equals(param)) {
                targetTableThreadPool.submit(this::cnsjFullParse);
            }
            if ("cwjz".equals(param)) {
                targetTableThreadPool.submit(this::cwjzFullParse);
            }
            if ("cwqrd".equals(param)) {
                targetTableThreadPool.submit(this::cwqrdFullParse);
            }
            if ("cwysp".equals(param)) {
                targetTableThreadPool.submit(this::cwyspFullParse);
            }
            if ("dwbzj".equals(param)) {
                targetTableThreadPool.submit(this::dwbzjFullParse);
            }
            if ("dzd".equals(param)) {
                targetTableThreadPool.submit(this::dzdFullParse);
            }
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
        while (true) {
            BusinessLogCwjz businessLog = cwjzMapper.getUnStartParseTaskOneRow();
            if (businessLog == null) {
                return;
            }
            try {
                LambdaUpdateWrapper<BusinessLogCwjz> wrapper = Wrappers.lambdaUpdate(BusinessLogCwjz.class)
                        .set(BusinessLog::getParseStatus, 1)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwjzMapper.update(null, wrapper);
                parseTask(businessLog.getParseRuleCode(), businessLog.getFileId(), businessLog.getParseRuleId());
                LambdaUpdateWrapper<BusinessLogCwjz> success = Wrappers.lambdaUpdate(BusinessLogCwjz.class)
                        .set(BusinessLog::getParseStatus, 2)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwjzMapper.update(null, success);
            } catch (Exception e) {
                log.error("cnsjFullParse error.", e);
                LambdaUpdateWrapper<BusinessLogCwjz> wrapper = Wrappers.lambdaUpdate(BusinessLogCwjz.class)
                        .set(BusinessLog::getParseStatus, 3)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwjzMapper.update(null, wrapper);
            }
        }
    }

    @Override
    public void cwqrdFullParse() {
        while (true) {
            BusinessLogCwqrd businessLog = cwqrdMapper.getUnStartParseTaskOneRow();
            if (businessLog == null) {
                return;
            }
            try {
                LambdaUpdateWrapper<BusinessLogCwqrd> wrapper = Wrappers.lambdaUpdate(BusinessLogCwqrd.class)
                        .set(BusinessLog::getParseStatus, 1)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwqrdMapper.update(null, wrapper);
                parseTask(businessLog.getParseRuleCode(), businessLog.getFileId(), businessLog.getParseRuleId());
                LambdaUpdateWrapper<BusinessLogCwqrd> success = Wrappers.lambdaUpdate(BusinessLogCwqrd.class)
                        .set(BusinessLog::getParseStatus, 2)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwqrdMapper.update(null, success);
            } catch (Exception e) {
                log.error("cnsjFullParse error.", e);
                LambdaUpdateWrapper<BusinessLogCwqrd> wrapper = Wrappers.lambdaUpdate(BusinessLogCwqrd.class)
                        .set(BusinessLog::getParseStatus, 3)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwqrdMapper.update(null, wrapper);
            }
        }
    }

    @Override
    public void cwyspFullParse() {
        while (true) {
            BusinessLogCwysp businessLog = cwyspMapper.getUnStartParseTaskOneRow();
            if (businessLog == null) {
                return;
            }
            try {
                LambdaUpdateWrapper<BusinessLogCwysp> wrapper = Wrappers.lambdaUpdate(BusinessLogCwysp.class)
                        .set(BusinessLog::getParseStatus, 1)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwyspMapper.update(null, wrapper);
                parseTask(businessLog.getParseRuleCode(), businessLog.getFileId(), businessLog.getParseRuleId());
                LambdaUpdateWrapper<BusinessLogCwysp> success = Wrappers.lambdaUpdate(BusinessLogCwysp.class)
                        .set(BusinessLog::getParseStatus, 2)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwyspMapper.update(null, success);
            } catch (Exception e) {
                log.error("cnsjFullParse error.", e);
                LambdaUpdateWrapper<BusinessLogCwysp> wrapper = Wrappers.lambdaUpdate(BusinessLogCwysp.class)
                        .set(BusinessLog::getParseStatus, 3)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwyspMapper.update(null, wrapper);
            }
        }
    }

    @Override
    public void dwbzjFullParse() {
        while (true) {
            BusinessLogDwbzj businessLog = dwbzjMapper.getUnStartParseTaskOneRow();
            if (businessLog == null) {
                return;
            }
            try {
                LambdaUpdateWrapper<BusinessLogDwbzj> wrapper = Wrappers.lambdaUpdate(BusinessLogDwbzj.class)
                        .set(BusinessLog::getParseStatus, 1)
                        .eq(BusinessLog::getId, businessLog.getId());
                dwbzjMapper.update(null, wrapper);
                parseTask(businessLog.getParseRuleCode(), businessLog.getFileId(), businessLog.getParseRuleId());
                LambdaUpdateWrapper<BusinessLogDwbzj> success = Wrappers.lambdaUpdate(BusinessLogDwbzj.class)
                        .set(BusinessLog::getParseStatus, 2)
                        .eq(BusinessLog::getId, businessLog.getId());
                dwbzjMapper.update(null, success);
            } catch (Exception e) {
                log.error("cnsjFullParse error.", e);
                LambdaUpdateWrapper<BusinessLogDwbzj> wrapper = Wrappers.lambdaUpdate(BusinessLogDwbzj.class)
                        .set(BusinessLog::getParseStatus, 3)
                        .eq(BusinessLog::getId, businessLog.getId());
                dwbzjMapper.update(null, wrapper);
            }
        }
    }

    @Override
    public void dzdFullParse() {
        while (true) {
            BusinessLogDzd businessLog = dzdMapper.getUnStartParseTaskOneRow();
            if (businessLog == null) {
                return;
            }
            try {
                LambdaUpdateWrapper<BusinessLogDzd> wrapper = Wrappers.lambdaUpdate(BusinessLogDzd.class)
                        .set(BusinessLog::getParseStatus, 1)
                        .eq(BusinessLog::getId, businessLog.getId());
                dzdMapper.update(null, wrapper);
                parseTask(businessLog.getParseRuleCode(), businessLog.getFileId(), businessLog.getParseRuleId());
                LambdaUpdateWrapper<BusinessLogDzd> success = Wrappers.lambdaUpdate(BusinessLogDzd.class)
                        .set(BusinessLog::getParseStatus, 2)
                        .eq(BusinessLog::getId, businessLog.getId());
                dzdMapper.update(null, success);
            } catch (Exception e) {
                log.error("cnsjFullParse error.", e);
                LambdaUpdateWrapper<BusinessLogDzd> wrapper = Wrappers.lambdaUpdate(BusinessLogDzd.class)
                        .set(BusinessLog::getParseStatus, 3)
                        .eq(BusinessLog::getId, businessLog.getId());
                dzdMapper.update(null, wrapper);
            }
        }
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
            sql = sql.replace("&{FILE_ID}", String.valueOf(fileId));
            for (TaskSqlParam taskSqlParam : taskSqlParams) {
                String subSql = sql;
                subSql = subSql.replace("${" + taskSqlParam.getKey() + "}", taskSqlParam.getValue());
                executeSql(taskSql, subSql, parseRuleCode, fileId, parseRuleId);
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
