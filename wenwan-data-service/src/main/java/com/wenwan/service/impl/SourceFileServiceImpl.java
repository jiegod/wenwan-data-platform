package com.wenwan.service.impl;

import com.wenwan.dao.entity.SourceFile;
import com.wenwan.model.FilePattern;
import com.wenwan.model.request.ListQuery;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.common.SourceFileService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SourceFileServiceImpl extends MapperConfigService<SourceFile, ListQuery> implements SourceFileService {


    @Override
    public List<SourceFile> regexp(FilePattern filePattern) {
        List<SourceFile> files = sourceFileMapper.regexp(filePattern);//todo 添加label筛选
        return files;
    }
}
