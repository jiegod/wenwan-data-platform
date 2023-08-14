package com.wenwan.service.impl;

import com.wenwan.mysql.dao.entity.BaseModel;
import com.wenwan.model.request.PageQuery;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.result.DashboardService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl extends MapperConfigService<BaseModel, PageQuery> implements DashboardService {

}
