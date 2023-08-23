package com.wenwan.service.component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.BusinessLogVo;
import com.wenwan.model.parse.request.BusinessLogQuery;
import com.wenwan.model.result.LogVo;
import com.wenwan.mysql.dao.dao.BusinessLogCnsjMapper;
import com.wenwan.mysql.dao.dao.ResultTableCnsjMapper;
import com.wenwan.mysql.dao.entity.BusinessLog;
import com.wenwan.mysql.dao.entity.BusinessLogCnsj;
import com.wenwan.mysql.dao.entity.ResultTable;
import com.wenwan.mysql.dao.entity.ResultTableCnsj;
import com.wenwan.service.constant.BusinessLogType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BusinessMapperCnsjStrategy implements BusinessMapperStrategy {

    @Autowired
    private BusinessLogCnsjMapper cnsjMapper;

    @Autowired
    private ResultTableCnsjMapper resultTableCnsjMapper;

    @Override
    public SearchResult<BusinessLogVo> fetchPatch(BusinessLogQuery businessLogQuery) {
        Page<BusinessLogCnsj> page = new Page<>(businessLogQuery.getPageNo(), businessLogQuery.getPageSize());
        LambdaQueryWrapper<BusinessLogCnsj> wrapper = Wrappers.lambdaQuery(BusinessLogCnsj.class)
                .eq(BusinessLogCnsj::getParseRuleId, businessLogQuery.getParseRuleId());
        cnsjMapper.selectPage(page, wrapper);
        List<BusinessLogVo> businessLogVos = page.getRecords().stream().map(businessLog -> {
            BusinessLogVo resultVo = new BusinessLogVo();
            BeanUtils.copyProperties(businessLog, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(businessLogVos, page.getTotal());
    }

    @Override
    public BusinessLogType getName() {
        return BusinessLogType.business_log_cnsj;
    }

    @Override
    public SearchResult<LogVo> list(LogVo logVo) {
        Page<BusinessLogCnsj> page = new Page<>(logVo.getPageNo(), logVo.getPageSize());
        LambdaQueryWrapper<BusinessLogCnsj> wrapper = Wrappers.lambdaQuery(BusinessLogCnsj.class)
                .eq(logVo.getParseRuleId() != null, BusinessLogCnsj::getParseRuleId, logVo.getParseRuleId())
                .eq(logVo.getFileId()!=null,BusinessLogCnsj::getFileId, logVo.getFileId())
                .eq(logVo.getLoadingStatus()!=null,BusinessLogCnsj::getLoadingStatus, logVo.getLoadingStatus())
                .eq(logVo.getTableStatus()!=null,BusinessLogCnsj::getTableStatus, logVo.getTableStatus())
                .eq(logVo.getParseStatus()!=null,BusinessLogCnsj::getParseStatus, logVo.getParseStatus())
                .ge(logVo.getQueryDateStart()!=null,BusinessLogCnsj::getOperationDate, logVo.getQueryDateStart())
                .le(logVo.getQueryDateEnd()!=null,BusinessLogCnsj::getOperationDate, logVo.getQueryDateEnd())
                ;
        Page<BusinessLogCnsj> result = cnsjMapper.selectPage(page, wrapper);
        List<LogVo> businessLogVos = result.getRecords().stream().map(businessLog -> {
            LogVo resultVo = new LogVo();
            BeanUtils.copyProperties(businessLog, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(businessLogVos, result.getTotal());
    }

    @Override
    public BusinessLog getBusinessLog(Long businessLogId) {
        return cnsjMapper.selectById(businessLogId);
    }

    @Override
    public ResultTable getResultTable(Long fileId) {
        return resultTableCnsjMapper.selectOne(Wrappers.lambdaQuery(ResultTableCnsj.class).eq(ResultTableCnsj::getFileId, fileId).orderByDesc(ResultTableCnsj::getId).last("limit 1"));
    }
}
