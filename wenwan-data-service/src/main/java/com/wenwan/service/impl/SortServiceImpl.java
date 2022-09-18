package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.common.constant.SortConst;
import com.wenwan.dao.entity.Label;
import com.wenwan.dao.entity.SortRule;
import com.wenwan.dao.entity.SourceFile;
import com.wenwan.dao.entity.SourceFileLabel;
import com.wenwan.model.FilePattern;
import com.wenwan.model.sort.SourceFileVo;
import com.wenwan.model.sort.TriggerSortVo;
import com.wenwan.service.api.ConfigCenter;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.common.LabelService;
import com.wenwan.service.api.sort.SortRuleService;
import com.wenwan.service.api.sort.SortService;
import com.wenwan.service.util.AsyncExecutor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SortServiceImpl extends MapperConfigService<SourceFile, SourceFileVo> implements SortService {

    @Autowired
    private SortRuleService sortRuleService;
    @Autowired
    private LabelService labelService;
    @Autowired
    private ConfigCenter configCenter;

    @Override
    public SearchResult<SourceFileVo> list(SourceFileVo sourceFileVo) {
        Page<SourceFile> page = new Page<>(sourceFileVo.getPageNo(), sourceFileVo.getPageSize());
        LambdaQueryWrapper<SourceFile> wrapper = Wrappers.lambdaQuery(SourceFile.class);
        addFilter(wrapper, sourceFileVo);
        sourceFileMapper.selectPage(page, wrapper);
        List<SourceFileVo> rows = page.getRecords().stream().map(sourceFile -> {
            SourceFileVo resultVo = new SourceFileVo();
            BeanUtils.copyProperties(sourceFile, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(rows, page.getTotal());
    }

    //1、插入label 2、更新file的labels 3、插入智能分拣
    @Override
    @Transactional
    public void trigger(TriggerSortVo triggerSortVo) {
        String[] labels = triggerSortVo.getLabels().split(",");
        for (String label : labels) {
            LambdaQueryWrapper<Label> wrapper = Wrappers.lambdaQuery(Label.class).eq(Label::getName, label);
            int count = labelMapper.selectCount(wrapper);
            if (count == 0) {
                Label label1 = new Label();
                label1.setName(label);
                labelMapper.insert(label1);
                SourceFileLabel sourceFileLabel = new SourceFileLabel();
                sourceFileLabel.setFileId(triggerSortVo.getFileId());
                sourceFileLabel.setLabelId(label1.getId());
                sourceFileLabelMapper.insert(sourceFileLabel);
            }
        }
        SourceFile sourceFile = new SourceFile();
        sourceFile.setId(triggerSortVo.getFileId());
        sourceFile.setLabels(triggerSortVo.getLabels());
        sourceFileMapper.updateById(sourceFile);
        if (triggerSortVo.getSortRuleVo() != null) {
            sortRuleService.insert(triggerSortVo.getSortRuleVo());
        }
    }

    @Override
    public void autoTrigger(Integer operateDate) {
        log.info("[SortService] trigger start:{}", operateDate);
        List<SortRule> sortRules;
        if (operateDate != null) {
            sortRules = sortRuleService.getSortRuleByDate(operateDate);
        } else {
            sortRules = sortRuleService.getALLSortRule();
        }
        sortRules.forEach(sortRule -> {
            Long id = 0L;
            while (true) {
                List<SourceFile> sourceFiles = new ArrayList<>();
                getSourceFile(sortRule, sourceFiles, operateDate, id);
                autoTrigger(sourceFiles, sortRule);
                if (sourceFiles.size() < configCenter.getTriggerSize()) {
                    break;
                }
                id = sourceFiles.get(sourceFiles.size() - 1).getId();
            }
        });
    }

    private void getSourceFile(SortRule sortRule, List<SourceFile> sourceFiles, Integer operateDate, Long id) {
        FilePattern filePattern = new FilePattern();
        filePattern.setFileNameRegular(sortRule.getFileNameRegular());
        filePattern.setReceiverRegular(sortRule.getReceiverRegular());
        filePattern.setSenderRegular(sortRule.getSenderRegular());
        filePattern.setThemeRegular(sortRule.getThemeRegular());
        filePattern.setOperationDate(operateDate);
        filePattern.setStatus(SortConst.FOR_SORT);
        filePattern.setSize(configCenter.getTriggerSize());
        filePattern.setId(id);
        sourceFiles.addAll(sourceFileMapper.regexp4Sort(filePattern));
    }

    private void autoTrigger(List<SourceFile> sourceFiles, final SortRule sortRule) {
        log.info("[SortService] autoTrigger size:{}", sourceFiles.size());
        if (CollectionUtils.isEmpty(sourceFiles)){
            return;
        }
        List<Future<?>> futures = sourceFiles.stream().map(sourceFile -> {
            return sortThreadPool.submit(() -> {
                sourceFile.setLabels(sortRule.getLabels());
                sourceFile.setStatus(SortConst.SORTED);
                sourceFileMapper.updateById(sourceFile);
            });
        }).collect(Collectors.toList());
        AsyncExecutor.wait(futures);
    }

    @Override
    protected void addFilter(LambdaQueryWrapper<SourceFile> wrapper, SourceFileVo sourceFileVo) {
        if (StringUtils.isNotEmpty(sourceFileVo.getSearch())) {
            wrapper.like(SourceFile::getFileName, sourceFileVo.getSearch())
                    .like(SourceFile::getTheme, sourceFileVo.getSearch());
        }
    }
}
