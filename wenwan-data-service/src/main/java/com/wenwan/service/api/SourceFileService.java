package com.wenwan.service.api;

import com.wenwan.dao.entity.SourceFile;
import com.wenwan.model.FilePattern;

import java.util.List;

public interface SourceFileService {

    List<SourceFile> regexp(FilePattern filePattern);
}
