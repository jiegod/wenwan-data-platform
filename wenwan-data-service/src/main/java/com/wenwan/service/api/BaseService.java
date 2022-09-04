package com.wenwan.service.api;

import com.wenwan.dao.dao.ParseRuleDao;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService implements InitializingBean {

    @Autowired
    protected ParseRuleDao parseRuleDao;

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
