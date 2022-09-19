package com.wenwan.service.util;

import com.wenwan.service.api.common.FileTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileTableFactory {

    @Autowired
    private List<FileTableService> fileTableServiceList;

    public FileTableService get(String fileName){
        return fileTableServiceList.stream().filter(t -> t.accept(fileName)).findAny().get();
    }

}
