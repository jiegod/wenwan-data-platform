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
    protected ParseRuleDao parseRuleDao;
    @Autowired
    protected SourceFileMapper sourceFileMapper;
    @Autowired
    protected SortRuleDao sortRuleDao;
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
