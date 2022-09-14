package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.dao.entity.Label;
import com.wenwan.dao.entity.SortRule;
import com.wenwan.model.sort.LabelVo;
import com.wenwan.model.sort.SortRuleVo;
import com.wenwan.service.api.ServiceConfig;
import com.wenwan.service.api.sort.SortRuleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortRuleServiceImpl extends ServiceConfig<SortRule, SortRuleVo> implements SortRuleService {

    @Override
    public Integer insert(SortRuleVo sortRuleVo) {
        SortRule sortRule = new SortRule();
        BeanUtils.copyProperties(sortRuleVo, sortRule);
        return sortRuleMapper.insert(sortRule);
    }

    @Override
    public Integer update(SortRuleVo sortRuleVo) {
        SortRule sortRule = new SortRule();
        BeanUtils.copyProperties(sortRuleVo, sortRule);
        return sortRuleMapper.updateById(sortRule);
    }

    @Override
    public SearchResult<SortRuleVo> list(SortRuleVo sortRuleVo) {
        Page<SortRule> page = new Page<>(sortRuleVo.getPageNo(), sortRuleVo.getPageSize());
        LambdaQueryWrapper<SortRule> wrapper = Wrappers.lambdaQuery(SortRule.class);
        addFilter(wrapper, sortRuleVo);
        sortRuleMapper.selectPage(page, wrapper);
        List<SortRuleVo> rows = page.getRecords().stream().map(parseRule -> {
            SortRuleVo resultVo = new SortRuleVo();
            BeanUtils.copyProperties(parseRule, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(rows, page.getTotal());
    }

    @Override
    public Integer delete(Long id) {
        return sortRuleMapper.deleteById(id);
    }

    @Override
    public List<LabelVo> labelList(LabelVo labelVo) {
        List<LabelVo> result = new ArrayList<>();
        LambdaQueryWrapper<Label> wrapper = Wrappers.lambdaQuery(Label.class)
                .like(Label::getName, labelVo.getName());
        if (StringUtils.isNotEmpty(labelVo.getReceiver())) {
            wrapper.eq(Label::getReceiver, labelVo.getReceiver());
        }
        List<Label> labels = labelMapper.selectList(wrapper);
        labels.forEach(label -> {
            LabelVo labelVo1 = new LabelVo();
            BeanUtils.copyProperties(label, labelVo1);
            result.add(labelVo1);
        });
        return result;
    }

    @Override
    protected void addFilter(LambdaQueryWrapper<SortRule> wrapper, SortRuleVo sortRuleVo){
        if (StringUtils.isNotEmpty(sortRuleVo.getSearch())){
            wrapper.like(SortRule::getName, sortRuleVo.getSearch());
        }
        if (StringUtils.isNotEmpty(sortRuleVo.getName())){
            wrapper.like(SortRule::getName, sortRuleVo.getName());
        }
        if (StringUtils.isNotEmpty(sortRuleVo.getLabels())){
            for(String label: sortRuleVo.getLabels().split(",")){
                wrapper.like(SortRule::getLabels, label);
            }
        }
        if (StringUtils.isNotEmpty(sortRuleVo.getSenderRegular())){
            wrapper.like(SortRule::getSenderRegular, sortRuleVo.getSenderRegular());
        }
        if (sortRuleVo.getExpireStart() != null){
            wrapper.ge(SortRule::getExpireStart, sortRuleVo.getExpireStart());
        }
        if (sortRuleVo.getExpireEnd() != null){
            wrapper.le(SortRule::getExpireEnd, sortRuleVo.getExpireEnd());
        }
        if (StringUtils.isNotEmpty(sortRuleVo.getFileNameRegular())){
            wrapper.like(SortRule::getFileNameRegular, sortRuleVo.getFileNameRegular());
        }
    }
}
