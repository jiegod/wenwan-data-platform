package com.wenwan.service.component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.dao.dao.BusinessLogCnsjMapper;
import com.wenwan.dao.dao.BusinessLogCwyspMapper;
import com.wenwan.dao.entity.BusinessLogCnsj;
import com.wenwan.dao.entity.BusinessLogCwjz;
import com.wenwan.dao.entity.BusinessLogCwysp;
import com.wenwan.model.parse.BusinessLogVo;
import com.wenwan.model.parse.request.BusinessLogQuery;
import com.wenwan.service.constant.BusinessLogType;
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
}
