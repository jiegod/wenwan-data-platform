package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.mysql.dao.entity.FileType;
import com.wenwan.mysql.dao.entity.ParseRule;
import com.wenwan.model.enums.Datasource;
import com.wenwan.model.parse.*;
import com.wenwan.model.parse.request.BusinessLogQuery;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.parse.ParseRuleService;
import com.wenwan.service.api.parse.TaskService;
import com.wenwan.service.component.BusinessMapperStrategy;
import com.wenwan.service.constant.BusinessLogType;
import com.wenwan.service.constant.TypeCache;
import com.wenwan.service.util.StringDateUtil;
import com.wenwan.service.util.UserStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ParseRuleServiceImpl extends MapperConfigService<ParseRule, ParseRuleVo> implements ParseRuleService {

    @Autowired
    private TaskService taskService;
    @Autowired
    private Map<BusinessLogType, BusinessMapperStrategy> businessLog;

    @Override
    public Integer insert(@RequestBody ParseRuleVo parseRuleVo) {
        LambdaQueryWrapper<FileType> wrapper = Wrappers.lambdaQuery(FileType.class).eq(FileType::getName, parseRuleVo.getFileType());
        int count = fileTypeMapper.selectCount(wrapper);
        if (count == 0) {
            FileType fileType = new FileType();
            fileType.setName(parseRuleVo.getFileType());
            fileType.setOperator(UserStorage.get());
            fileType.setOperationDate(StringDateUtil.getToday());
            fileTypeMapper.insert(fileType);
        }
        ParseRule parseRule = new ParseRule();
        BeanUtils.copyProperties(parseRuleVo, parseRule);
        parseRule.setOperator(UserStorage.get());
        parseRule.setOperationDate(StringDateUtil.getToday());
        return parseRuleMapper.insert(parseRule);
    }

    @Override
    public Integer delete(Long id) {
        LambdaQueryWrapper<ParseRule> wrapper = Wrappers.lambdaQuery(ParseRule.class).eq(ParseRule::getId, id);
        return parseRuleMapper.delete(wrapper);
    }

    @Override
    public Integer update(ParseRuleVo parseRuleVo) {
        ParseRule parseRule = new ParseRule();
        BeanUtils.copyProperties(parseRuleVo, parseRule);
        parseRule.setOperator(UserStorage.get());
        parseRule.setOperationDate(StringDateUtil.getToday());
        return parseRuleMapper.updateById(parseRule);
    }

    @Override
    public SearchResult<ParseRuleVo> list(ParseRuleVo parseRuleVo) {
        Page<ParseRule> page = new Page<>(parseRuleVo.getPageNo(), parseRuleVo.getPageSize());
        LambdaQueryWrapper<ParseRule> wrapper = Wrappers.lambdaQuery(ParseRule.class);
        addFilter(wrapper, parseRuleVo);
        parseRuleMapper.selectPage(page, wrapper);
        List<Long> parseRuleIds = page.getRecords().stream().map(ParseRule::getId).collect(Collectors.toList());
        Map<Long, List<ParseRuleTableVo>> tableInfoMap = taskService.getTableByParseRuleId(parseRuleIds);
        List<ParseRuleVo> rows = page.getRecords().stream().map(parseRule -> {
            ParseRuleVo resultVo = new ParseRuleVo();
            BeanUtils.copyProperties(parseRule, resultVo);
            resultVo.setTableInfoVos(tableInfoMap.get(parseRule.getId()));
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(rows, page.getTotal());
    }

    @Override
    public List<FileTypeVo> fileTypeList(FileTypeVo fileTypeVo) {
        List<FileTypeVo> result = new ArrayList<>();
        LambdaQueryWrapper<FileType> wrapper = Wrappers.lambdaQuery(FileType.class);
        if (StringUtils.isNotBlank(fileTypeVo.getName())){
            wrapper.like(FileType::getName, fileTypeVo.getName());
        }
        List<FileType> fileTypes = fileTypeMapper.selectList(wrapper);
        fileTypes.forEach(fileType -> {
            FileTypeVo fileTypeVo1 = new FileTypeVo();
            BeanUtils.copyProperties(fileType, fileTypeVo1);
            result.add(fileTypeVo1);
        });
        return result;
    }

    @Override
    public List<ParseRule> all4Parse(Datasource datasource) {
        LambdaQueryWrapper<ParseRule> wrapper = Wrappers.lambdaQuery(ParseRule.class)
                .eq(ParseRule::getStatus, 0)
                .eq(ParseRule::getDataSource,datasource.getCode())
                .orderByAsc(ParseRule::getFileType)
                .orderByAsc(ParseRule::getPriority);
        return parseRuleMapper.selectList(wrapper);
    }

    @Override
    public Map<String, Set<String>> dropList(FilterKey filterKey) {
        if (filterKey == null) {
            return TypeCache.allType;
        }
        Map<String, Set<String>> result = new HashMap<>();
        result.put(filterKey.name(), TypeCache.allType.get(filterKey.name()));
        return result;
    }

    @Override
    public SearchResult<BusinessLogVo> businessLog(BusinessLogQuery businessLogQuery) {
        ParseRule parseRule = parseRuleMapper.selectById(businessLogQuery.getParseRuleId());
        SearchResult<BusinessLogVo> searchResult = businessLog.get(BusinessLogType.valueOf(parseRule.getBusinessLog())).fetchPatch(businessLogQuery);
        return searchResult;
    }

    @Override
    protected void addFilter(LambdaQueryWrapper<ParseRule> wrapper, ParseRuleVo parseRuleVo) {
        if (StringUtils.isNotBlank(parseRuleVo.getSearch())) {
            wrapper.like(ParseRule::getName, parseRuleVo.getSearch());
        }
        if (StringUtils.isNotBlank(parseRuleVo.getDataSource())) {
            wrapper.eq(ParseRule::getDataSource, parseRuleVo.getDataSource());
        }
        if (StringUtils.isNotBlank(parseRuleVo.getFileType())) {
            wrapper.eq(ParseRule::getFileType, parseRuleVo.getFileType());
        }
        if (StringUtils.isNotBlank(parseRuleVo.getCode())) {
            wrapper.eq(ParseRule::getCode, parseRuleVo.getCode());
        }
    }
}
