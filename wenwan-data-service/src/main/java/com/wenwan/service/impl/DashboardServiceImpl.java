package com.wenwan.service.impl;

import com.wenwan.dao.entity.BaseModel;
import com.wenwan.model.request.PageQuery;
import com.wenwan.service.api.ServiceConfig;
import com.wenwan.service.api.result.DashboardService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl extends ServiceConfig<BaseModel, PageQuery> implements DashboardService {

}
