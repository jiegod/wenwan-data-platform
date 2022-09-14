package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wenwan.dao.entity.BaseModel;
import com.wenwan.model.request.BaseQuery;
import com.wenwan.service.api.BaseService;
import com.wenwan.service.api.result.DashboardService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl extends BaseService<BaseModel, BaseQuery> implements DashboardService {
    @Override
    protected void addFilter(LambdaQueryWrapper<BaseModel> wrapper, BaseQuery baseQuery) {

    }
}
