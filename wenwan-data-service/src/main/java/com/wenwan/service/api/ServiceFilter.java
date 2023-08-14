package com.wenwan.service.api;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wenwan.mysql.dao.entity.BaseModel;
import com.wenwan.model.request.ListQuery;
import org.springframework.beans.factory.InitializingBean;

public abstract class ServiceFilter<T extends BaseModel, V extends ListQuery> implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {

    }

    protected abstract void addFilter(LambdaQueryWrapper<T> wrapper, V v);
}
