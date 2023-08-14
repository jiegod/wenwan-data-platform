package com.wenwan.service.impl;

import com.wenwan.mysql.dao.entity.SourceFile;
import com.wenwan.model.request.ListQuery;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.common.SourceFileService;
import org.springframework.stereotype.Component;

@Component
public class SourceFileServiceImpl extends MapperConfigService<SourceFile, ListQuery> implements SourceFileService {


}
