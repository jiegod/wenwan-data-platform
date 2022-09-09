package com.wenwan.service.api;

import com.wenwan.dao.dao.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService implements InitializingBean {

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

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
