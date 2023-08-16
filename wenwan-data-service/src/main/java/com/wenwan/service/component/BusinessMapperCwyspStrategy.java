package com.wenwan.service.component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.result.LogVo;
import com.wenwan.mysql.dao.dao.BusinessLogCnsjMapper;
import com.wenwan.mysql.dao.dao.BusinessLogCwyspMapper;
import com.wenwan.mysql.dao.entity.BusinessLog;
import com.wenwan.mysql.dao.entity.BusinessLogCnsj;
import com.wenwan.mysql.dao.entity.BusinessLogCwjz;
import com.wenwan.mysql.dao.entity.BusinessLogCwysp;
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
public class BusinessMapperCwyspStrategy implements BusinessMapperStrategy {

    @Autowired
    private BusinessLogCwyspMapper cwyspMapper;

    @Override
    public SearchResult<BusinessLogVo> fetchPatch(BusinessLogQuery businessLogQuery) {
        Page<BusinessLogCwysp> page = new Page<>(businessLogQuery.getPageNo(), businessLogQuery.getPageSize());
        LambdaQueryWrapper<BusinessLogCwysp> wrapper = Wrappers.lambdaQuery(BusinessLogCwysp.class)
                .eq(BusinessLogCwysp::getParseRuleId, businessLogQuery.getParseRuleId());
        cwyspMapper.selectPage(page, wrapper);
        List<BusinessLogVo> businessLogVos = page.getRecords().stream().map(businessLog -> {
            BusinessLogVo resultVo = new BusinessLogVo();
            BeanUtils.copyProperties(businessLog, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(businessLogVos, page.getTotal());
    }

    @Override
    public BusinessLogType getName() {
        return BusinessLogType.business_log_cwysp;
    }

    @Override
    public SearchResult<LogVo> list(LogVo logVo) {
        Page<BusinessLogCwysp> page = new Page<>(logVo.getPageNo(), logVo.getPageSize());
        LambdaQueryWrapper<BusinessLogCwysp> wrapper = Wrappers.lambdaQuery(BusinessLogCwysp.class)
                .eq(StringUtils.isNotBlank(logVo.getParseRuleCode()),BusinessLogCwysp::getParseRuleCode, logVo.getParseRuleCode())
                .eq(logVo.getFileId()!=null,BusinessLogCwysp::getFileId, logVo.getFileId())
                .eq(logVo.getLoadingStatus()!=null,BusinessLogCwysp::getLoadingStatus, logVo.getLoadingStatus())
                .eq(logVo.getTableStatus()!=null,BusinessLogCwysp::getTableStatus, logVo.getTableStatus())
                .eq(logVo.getParseStatus()!=null,BusinessLogCwysp::getParseStatus, logVo.getParseStatus())
                .ge(logVo.getQueryDateStart()!=null,BusinessLogCwysp::getOperationDate, logVo.getParseStatus())
                .le(logVo.getQueryDateEnd()!=null,BusinessLogCwysp::getOperationDate, logVo.getQueryDateEnd())
                ;
        Page<BusinessLogCwysp> result = cwyspMapper.selectPage(page, wrapper);
        List<LogVo> businessLogVos = result.getRecords().stream().map(businessLog -> {
            LogVo resultVo = new LogVo();
            BeanUtils.copyProperties(businessLog, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(businessLogVos, result.getTotal());
    }

    @Override
    public BusinessLog getBusinessLog(Long businessLogId) {
        return cwyspMapper.selectById(businessLogId);
    }
}
