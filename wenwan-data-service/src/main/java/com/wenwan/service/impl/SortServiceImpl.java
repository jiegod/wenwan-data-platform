package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.dao.entity.Label;
import com.wenwan.dao.entity.SourceFile;
import com.wenwan.model.sort.SourceFileVo;
import com.wenwan.model.sort.TriggerSortVo;
import com.wenwan.service.api.BaseService;
import com.wenwan.service.api.sort.SortRuleService;
import com.wenwan.service.api.sort.SortService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortServiceImpl extends BaseService implements SortService {

    @Autowired
    private SortRuleService sortRuleService;

    @Override
    public SearchResult<SourceFileVo> list(SourceFileVo sourceFileVo) {
        Page<SourceFile> page = new Page<>(sourceFileVo.getPageNo(), sourceFileVo.getPageSize());
        LambdaQueryWrapper<SourceFile> wrapper = Wrappers.lambdaQuery(SourceFile.class);
        sourceFileMapper.selectPage(page, wrapper);
        List<SourceFileVo> rows = page.getRecords().stream().map(sourceFile -> {
            SourceFileVo resultVo = new SourceFileVo();
            BeanUtils.copyProperties(sourceFile, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(rows, page.getTotal());
    }

    @Override
    public void trigger(TriggerSortVo triggerSortVo) {
        String[] labels = triggerSortVo.getLabels().split(",");
        for(String label: labels){
            LambdaQueryWrapper<Label> wrapper = Wrappers.lambdaQuery(Label.class).eq(Label::getName, label);
            int count = labelMapper.selectCount(wrapper);
            if (count == 0){
                Label label1 = new Label();
                label1.setName(label);
                labelMapper.insert(label1);
            }
        }
        SourceFile sourceFile = new SourceFile();
        sourceFile.setId(triggerSortVo.getFileId());
        sourceFile.setLabels(triggerSortVo.getLabels());
        sourceFileMapper.updateById(sourceFile);
        if (triggerSortVo.getSortRuleVo() != null){
            sortRuleService.insert(triggerSortVo.getSortRuleVo());
        }
    }
}