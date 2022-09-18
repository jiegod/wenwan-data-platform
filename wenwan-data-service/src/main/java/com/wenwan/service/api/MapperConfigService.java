package com.wenwan.service.api;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wenwan.dao.dao.*;
import com.wenwan.dao.entity.BaseModel;
import com.wenwan.model.request.ListQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MapperConfigService<T extends BaseModel, V extends ListQuery> extends ServiceFilter<T, V> {

    @Autowired
    protected BusinessLogMapper businessLogMapper;
    @Autowired
    protected ColumnInfoMapper columnInfoMapper;
    @Autowired
    protected FileTypeMapper fileTypeMapper;
    @Autowired
    protected LabelMapper labelMapper;
    @Autowired
    protected SourceFileLabelMapper sourceFileLabelMapper;
    @Autowired
    protected ParseTableMappingMapper parseTableMappingMapper;
    @Autowired
    protected SortRuleMapper sortRuleMapper;
    @Autowired
    protected SourceFileMapper sourceFileMapper;
    @Autowired
    protected SqlLogMapper sqlLogMapper;
    @Autowired
    protected TableInfoMapper tableInfoMapper;
    @Autowired
    protected TaskGroupMapper taskGroupMapper;
    @Autowired
    protected TaskSqlMapper taskSqlMapper;
    @Autowired
    protected ParseRuleMapper parseRuleMapper;
    @Autowired
    protected TaskSqlParamMapper taskSqlParamMapper;
    @Autowired
    protected UserMapper userMapper;

    @Override
    protected void addFilter(LambdaQueryWrapper<T> wrapper, V baseQuery) {

    }

    protected static final ExecutorService insertThreadPool = Executors.newFixedThreadPool(100);
    protected static final ExecutorService sortThreadPool = Executors.newFixedThreadPool(100);
}
