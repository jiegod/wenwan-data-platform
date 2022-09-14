package com.wenwan.service.api;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wenwan.dao.dao.*;
import com.wenwan.dao.entity.BaseModel;
import com.wenwan.model.request.BaseQuery;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class BaseService<T extends BaseModel, V extends BaseQuery> implements InitializingBean {

    @Autowired
    protected BusinessLogMapper businessLogMapper;
    @Autowired
    protected ColumnInfoMapper columnInfoMapper;
    @Autowired
    protected FileTypeMapper fileTypeMapper;
    @Autowired
    protected LabelMapper labelMapper;
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

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    protected abstract void addFilter(LambdaQueryWrapper<T> wrapper, V v);

    protected static final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
}
