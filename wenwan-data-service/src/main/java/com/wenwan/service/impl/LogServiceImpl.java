package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.common.api.SearchResult;
import com.wenwan.dao.entity.SqlLog;
import com.wenwan.model.result.LogVo;
import com.wenwan.model.result.SqlLogVo;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.result.LogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl extends MapperConfigService<SqlLog, SqlLogVo> implements LogService {

    @Override
    public SearchResult<LogVo> list(LogVo logVo) {
        //todo 不知道取哪个表
        return null;
    }

    @Override
    public SearchResult<SqlLogVo> sqlLogList(SqlLogVo sqlLogVo) {
        LambdaQueryWrapper<SqlLog> wrapper = Wrappers.lambdaQuery(SqlLog.class);
        addFilter(wrapper, sqlLogVo);
        List<SqlLog> sqlLogs = sqlLogMapper.selectList(wrapper);
        List<SqlLogVo> result = sqlLogs.stream().map(sqlLog -> {
            SqlLogVo sqlLogVo1 = new SqlLogVo();
            BeanUtils.copyProperties(sqlLog, sqlLogVo1);
            return sqlLogVo1;
        }).collect(Collectors.toList());
        return new SearchResult<>(result, result.size());
    }


    @Override
    protected void addFilter(LambdaQueryWrapper<SqlLog> wrapper, SqlLogVo sqlLogVo) {
        if (StringUtils.isNotBlank(sqlLogVo.getTaskSqlCode())) {
            wrapper.like(SqlLog::getTaskSqlCode, sqlLogVo.getTaskSqlCode());
        }
    }
}
