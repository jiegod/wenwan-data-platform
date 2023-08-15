package com.wenwan.service.component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.result.LogVo;
import com.wenwan.mysql.dao.dao.BusinessLogCnsjMapper;
import com.wenwan.mysql.dao.dao.BusinessLogDwbzjMapper;
import com.wenwan.mysql.dao.entity.BusinessLog;
import com.wenwan.mysql.dao.entity.BusinessLogCnsj;
import com.wenwan.mysql.dao.entity.BusinessLogCwjz;
import com.wenwan.mysql.dao.entity.BusinessLogDwbzj;
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
public class BusinessMapperDwbzjStrategy implements BusinessMapperStrategy {

    @Autowired
    private BusinessLogDwbzjMapper dwbzjMapper;

    @Override
    public SearchResult<BusinessLogVo> fetchPatch(BusinessLogQuery businessLogQuery) {
        Page<BusinessLogDwbzj> page = new Page<>(businessLogQuery.getPageNo(), businessLogQuery.getPageSize());
        LambdaQueryWrapper<BusinessLogDwbzj> wrapper = Wrappers.lambdaQuery(BusinessLogDwbzj.class)
                .eq(BusinessLogDwbzj::getParseRuleId, businessLogQuery.getParseRuleId());
        dwbzjMapper.selectPage(page, wrapper);
        List<BusinessLogVo> businessLogVos = page.getRecords().stream().map(businessLog -> {
            BusinessLogVo resultVo = new BusinessLogVo();
            BeanUtils.copyProperties(businessLog, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(businessLogVos, page.getTotal());
    }

    @Override
    public BusinessLogType getName() {
        return BusinessLogType.business_log_dwbzj;
    }

    @Override
    public SearchResult<LogVo> list(LogVo logVo) {
        Page<BusinessLogDwbzj> page = new Page<>(logVo.getPageNo(), logVo.getPageSize());
        LambdaQueryWrapper<BusinessLogDwbzj> wrapper = Wrappers.lambdaQuery(BusinessLogDwbzj.class)
                .eq(StringUtils.isNotBlank(logVo.getParseRuleCode()),BusinessLogDwbzj::getParseRuleCode, logVo.getParseRuleCode())
                .eq(logVo.getFileId()!=null,BusinessLogDwbzj::getFileId, logVo.getFileId())
                .eq(logVo.getLoadingStatus()!=null,BusinessLogDwbzj::getLoadingStatus, logVo.getLoadingStatus())
                .eq(logVo.getTableStatus()!=null,BusinessLogDwbzj::getTableStatus, logVo.getTableStatus())
                .eq(logVo.getParseStatus()!=null,BusinessLogDwbzj::getParseStatus, logVo.getParseStatus())
                .ge(logVo.getQueryDateStart()!=null,BusinessLogDwbzj::getOperationDate, logVo.getParseStatus())
                .le(logVo.getQueryDateEnd()!=null,BusinessLogDwbzj::getOperationDate, logVo.getQueryDateEnd())
                ;
        Page<BusinessLogDwbzj> result = dwbzjMapper.selectPage(page, wrapper);
        List<LogVo> businessLogVos = result.getRecords().stream().map(businessLog -> {
            LogVo resultVo = new LogVo();
            BeanUtils.copyProperties(businessLog, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(businessLogVos, result.getTotal());
    }

    @Override
    public BusinessLog getBusinessLog(Long businessLogId) {
        return dwbzjMapper.selectById(businessLogId);
    }
}
