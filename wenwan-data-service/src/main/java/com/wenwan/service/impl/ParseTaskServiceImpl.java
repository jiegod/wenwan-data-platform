package com.wenwan.service.impl;

import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.parse.ParseTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ParseTaskServiceImpl extends MapperConfigService implements ParseTaskService {
    // todo 目前只实现全量加载，后续必须实现增量，需要记录游标
    @Override
    public void incrParse() {

    }

    @Override
    public void fullParse() {

    }
}
