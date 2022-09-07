package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.dao.entity.ParseRule;
import com.wenwan.model.parse.FileTypeVo;
import com.wenwan.model.parse.ParseRuleVo;
import com.wenwan.service.api.BaseService;
import com.wenwan.service.api.parse.ParseRuleService;
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
    public Integer insert(@RequestBody ParseRuleVo parseRuleVo) {
        ParseRule parseRule = new ParseRule();
        BeanUtils.copyProperties(parseRuleVo, parseRule);
        return parseRuleDao.insert(parseRule);
    }

    @Override
    public Integer delete(Long id) {
        LambdaQueryWrapper<ParseRule> wrapper = Wrappers.lambdaQuery(ParseRule.class).eq(ParseRule::getId, id);
        return parseRuleDao.delete(wrapper);
    }

    @Override
    public Integer update(ParseRuleVo parseRuleVo) {
        ParseRule parseRule = new ParseRule();
        BeanUtils.copyProperties(parseRuleVo, parseRule);
        return  parseRuleDao.updateById(parseRule);
    }

    @Override
    public SearchResult<ParseRuleVo> list(ParseRuleVo parseRuleVo) {
        Page<ParseRule> page = new Page<>(parseRuleVo.getPageNo(), parseRuleVo.getPageSize());
        LambdaQueryWrapper<ParseRule> wrapper = Wrappers.lambdaQuery(ParseRule.class);
        parseRuleDao.selectPage(page, wrapper);
        List<ParseRuleVo> rows = page.getRecords().stream().map(parseRule -> {
            ParseRuleVo resultVo = new ParseRuleVo();
            BeanUtils.copyProperties(parseRule, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(rows, page.getTotal());
    }

    @Override
    public List<FileTypeVo> fileTypeList(FileTypeVo fileTypeVo) {
        return null;
    }
}
