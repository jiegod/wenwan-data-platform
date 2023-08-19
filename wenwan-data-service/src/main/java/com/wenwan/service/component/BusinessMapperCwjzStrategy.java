package com.wenwan.service.component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.result.LogVo;
import com.wenwan.mysql.dao.dao.BusinessLogCnsjMapper;
import com.wenwan.mysql.dao.dao.BusinessLogCwjzMapper;
import com.wenwan.mysql.dao.entity.BusinessLog;
import com.wenwan.mysql.dao.entity.BusinessLogCnsj;
import com.wenwan.mysql.dao.entity.BusinessLogCwjz;
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
public class BusinessMapperCwjzStrategy implements BusinessMapperStrategy {

    @Autowired
    private BusinessLogCwjzMapper cwjzMapper;

    @Override
    public SearchResult<BusinessLogVo> fetchPatch(BusinessLogQuery businessLogQuery) {
        Page<BusinessLogCwjz> page = new Page<>(businessLogQuery.getPageNo(), businessLogQuery.getPageSize());
        LambdaQueryWrapper<BusinessLogCwjz> wrapper = Wrappers.lambdaQuery(BusinessLogCwjz.class)
                .eq(BusinessLogCwjz::getParseRuleId, businessLogQuery.getParseRuleId());
        cwjzMapper.selectPage(page, wrapper);
        List<BusinessLogVo> businessLogVos = page.getRecords().stream().map(businessLog -> {
            BusinessLogVo resultVo = new BusinessLogVo();
            BeanUtils.copyProperties(businessLog, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(businessLogVos, page.getTotal());
    }

    @Override
    public BusinessLogType getName() {
        return BusinessLogType.business_log_cwjz;
    }

    @Override
    public SearchResult<LogVo> list(LogVo logVo) {
        Page<BusinessLogCwjz> page = new Page<>(logVo.getPageNo(), logVo.getPageSize());
        LambdaQueryWrapper<BusinessLogCwjz> wrapper = Wrappers.lambdaQuery(BusinessLogCwjz.class)
                .eq(logVo.getParseRuleId() != null, BusinessLogCwjz::getParseRuleId, logVo.getParseRuleId())
                .eq(logVo.getFileId()!=null,BusinessLogCwjz::getFileId, logVo.getFileId())
                .eq(logVo.getLoadingStatus()!=null,BusinessLogCwjz::getLoadingStatus, logVo.getLoadingStatus())
                .eq(logVo.getTableStatus()!=null,BusinessLogCwjz::getTableStatus, logVo.getTableStatus())
                .eq(logVo.getParseStatus()!=null,BusinessLogCwjz::getParseStatus, logVo.getParseStatus())
                .ge(logVo.getQueryDateStart()!=null,BusinessLogCwjz::getOperationDate, logVo.getParseStatus())
                .le(logVo.getQueryDateEnd()!=null,BusinessLogCwjz::getOperationDate, logVo.getQueryDateEnd())
                ;
        Page<BusinessLogCwjz> result = cwjzMapper.selectPage(page, wrapper);
        List<LogVo> businessLogVos = result.getRecords().stream().map(businessLog -> {
            LogVo resultVo = new LogVo();
            BeanUtils.copyProperties(businessLog, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(businessLogVos, result.getTotal());
    }

    @Override
    public BusinessLog getBusinessLog(Long businessLogId) {
        return cwjzMapper.selectById(businessLogId);
    }
}
