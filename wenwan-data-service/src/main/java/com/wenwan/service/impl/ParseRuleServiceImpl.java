package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.dao.entity.ParseRule;
import com.wenwan.model.parse.FileTypeVo;
import com.wenwan.model.parse.ParseRuleVo;
import com.wenwan.service.api.BaseService;
import com.wenwan.service.api.ParseRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ParseRuleServiceImpl extends BaseService implements ParseRuleService{


    @Override
    public APIResponse<Void> insert(@RequestBody ParseRuleVo parseRuleVo) {
        ParseRule parseRule = new ParseRule();
        BeanUtils.copyProperties(parseRuleVo, parseRule);
        parseRuleDao.insert(parseRule);
        return null;
    }

    @Override
    public APIResponse<Void> delete(Long id) {
        LambdaQueryWrapper<ParseRule> wrapper = Wrappers.lambdaQuery(ParseRule.class).eq(ParseRule::getId, id);
        parseRuleDao.delete(wrapper);
        return null;
    }

    @Override
    public APIResponse<Void> update(ParseRuleVo parseRuleVo) {
        ParseRule parseRule = new ParseRule();
        BeanUtils.copyProperties(parseRuleVo, parseRule);
        parseRuleDao.updateById(parseRule);
        return null;
    }

    @Override
    public APIResponse<SearchResult<ParseRuleVo>> list(ParseRuleVo parseRuleVo) {
        Page<ParseRule> page = new Page<>(parseRuleVo.getPageNo(), parseRuleVo.getPageSize());
        LambdaQueryWrapper<ParseRule> wrapper = Wrappers.lambdaQuery(ParseRule.class);
        parseRuleDao.selectPage(page, wrapper);
        List<ParseRuleVo> rows = page.getRecords().stream().map(parseRule -> {
            ParseRuleVo resultVo = new ParseRuleVo();
            BeanUtils.copyProperties(parseRule, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return APIResponse.getOkJsonResult(new SearchResult<>(rows, page.getTotal()));
    }

    @Override
    public APIResponse<List<FileTypeVo>> fileTypeList(FileTypeVo fileTypeVo) {
        return null;
    }
}
