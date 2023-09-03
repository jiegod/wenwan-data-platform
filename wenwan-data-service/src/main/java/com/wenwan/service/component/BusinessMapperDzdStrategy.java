package com.wenwan.service.component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.result.LogVo;
import com.wenwan.mysql.dao.dao.BusinessLogDzdMapper;
import com.wenwan.mysql.dao.dao.ResultTableDwbzjMapper;
import com.wenwan.mysql.dao.dao.ResultTableDzdMapper;
import com.wenwan.mysql.dao.entity.*;
import com.wenwan.model.parse.BusinessLogVo;
import com.wenwan.model.parse.request.BusinessLogQuery;
import com.wenwan.service.constant.BusinessLogType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class BusinessMapperDzdStrategy implements BusinessMapperStrategy {

    @Autowired
    private BusinessLogDzdMapper dzdMapper;

    @Autowired
    private ResultTableDzdMapper resultTableDzdMapper;

    @Override
    public SearchResult<BusinessLogVo> fetchPatch(BusinessLogQuery businessLogQuery) {
        Page<BusinessLogDzd> page = new Page<>(businessLogQuery.getPageNo(), businessLogQuery.getPageSize());
        LambdaQueryWrapper<BusinessLogDzd> wrapper = Wrappers.lambdaQuery(BusinessLogDzd.class)
                .eq(BusinessLogDzd::getParseRuleId, businessLogQuery.getParseRuleId());
        dzdMapper.selectPage(page, wrapper);
        List<BusinessLogVo> businessLogVos = page.getRecords().stream().map(businessLog -> {
            BusinessLogVo resultVo = new BusinessLogVo();
            BeanUtils.copyProperties(businessLog, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(businessLogVos, page.getTotal());
    }

    @Override
    public BusinessLogType getName() {
        return BusinessLogType.business_log_dzd;
    }

    @Override
    public SearchResult<LogVo> list(LogVo logVo) {
        Page<BusinessLogDzd> page = new Page<>(logVo.getPageNo(), logVo.getPageSize());
        LambdaQueryWrapper<BusinessLogDzd> wrapper = Wrappers.lambdaQuery(BusinessLogDzd.class)
                .eq(logVo.getParseRuleId() != null, BusinessLogDzd::getParseRuleId, logVo.getParseRuleId())
                .eq(logVo.getFileId()!=null,BusinessLogDzd::getFileId, logVo.getFileId())
                .eq(logVo.getLoadingStatus()!=null,BusinessLogDzd::getLoadingStatus, logVo.getLoadingStatus())
                .eq(logVo.getTableStatus()!=null,BusinessLogDzd::getTableStatus, logVo.getTableStatus())
                .eq(logVo.getParseStatus()!=null,BusinessLogDzd::getParseStatus, logVo.getParseStatus())
                .ge(logVo.getQueryDateStart()!=null,BusinessLogDzd::getOperationDate, logVo.getQueryDateStart())
                .le(logVo.getQueryDateEnd()!=null,BusinessLogDzd::getOperationDate, logVo.getQueryDateEnd())
                ;
        Page<BusinessLogDzd> result = dzdMapper.selectPage(page, wrapper);
        List<LogVo> businessLogVos = result.getRecords().stream().map(businessLog -> {
            LogVo resultVo = new LogVo();
            BeanUtils.copyProperties(businessLog, resultVo);
            resultVo.setBusinessLog(BusinessLogType.business_log_dzd.name());
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(businessLogVos, result.getTotal());
    }

    @Override
    public BusinessLog getBusinessLog(Long businessLogId) {
        return dzdMapper.selectById(businessLogId);
    }

    @Override
    public ResultTable getResultTable(Long fileId) {
        return resultTableDzdMapper.selectOne(Wrappers.lambdaQuery(ResultTableDzd.class).eq(ResultTableDzd::getFileId, fileId).orderByDesc(ResultTableDzd::getId).last("limit 1"));
    }
}
