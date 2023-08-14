package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.dao.entity.*;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.common.FileTableService;
import com.wenwan.service.api.parse.GenerateTargetTableService;
import com.wenwan.service.util.FileTableFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenerateTargetTableServiceImpl extends MapperConfigService implements GenerateTargetTableService {

    @Autowired
    private FileTableFactory fileTableFactory;

    // todo 目前只实现全量加载，后续必须实现增量，需要记录游标
    @Override
    public void incrParse() {

    }

    @Override
    public void cnsjFullParse() {
        while (true) {
            BusinessLogCnsj businessLog = cnsjMapper.getUnStartOneRow();
            LambdaUpdateWrapper<BusinessLogCnsj> wrapper = Wrappers.lambdaUpdate(BusinessLogCnsj.class)
                    .set(BusinessLog::getTableStatus, 1)
                    .eq(BusinessLog::getId, businessLog.getId());
            cnsjMapper.update(null, wrapper);
            parseTable(businessLog);
        }
    }

    @Override
    public void cwjzFullParse() {
        while (true) {
            BusinessLogCwjz businessLog = cwjzMapper.getUnStartOneRow();
            LambdaUpdateWrapper<BusinessLogCwjz> wrapper = Wrappers.lambdaUpdate(BusinessLogCwjz.class)
                    .set(BusinessLog::getTableStatus, 1)
                    .eq(BusinessLog::getId, businessLog.getId());
            cwjzMapper.update(null, wrapper);
            parseTable(businessLog);
        }
    }

    @Override
    public void cwqrdFullParse() {
        while (true) {
            BusinessLogCwqrd businessLog = cwqrdMapper.getUnStartOneRow();
            LambdaUpdateWrapper<BusinessLogCwqrd> wrapper = Wrappers.lambdaUpdate(BusinessLogCwqrd.class)
                    .set(BusinessLog::getTableStatus, 1)
                    .eq(BusinessLog::getId, businessLog.getId());
            cwqrdMapper.update(null, wrapper);
            parseTable(businessLog);
        }
    }

    @Override
    public void cwyspFullParse() {
        while (true) {
            BusinessLogCwysp businessLog = cwyspMapper.getUnStartOneRow();
            LambdaUpdateWrapper<BusinessLogCwysp> wrapper = Wrappers.lambdaUpdate(BusinessLogCwysp.class)
                    .set(BusinessLog::getTableStatus, 1)
                    .eq(BusinessLog::getId, businessLog.getId());
            cwyspMapper.update(null, wrapper);
            parseTable(businessLog);
        }
    }

    @Override
    public void dwbzjFullParse() {
        while (true) {
            BusinessLogDwbzj businessLog = dwbzjMapper.getUnStartOneRow();
            LambdaUpdateWrapper<BusinessLogDwbzj> wrapper = Wrappers.lambdaUpdate(BusinessLogDwbzj.class)
                    .set(BusinessLog::getTableStatus, 1)
                    .eq(BusinessLog::getId, businessLog.getId());
            dwbzjMapper.update(null, wrapper);
            parseTable(businessLog);
        }
    }

    @Override
    public void dzdFullParse() {
        while (true) {
            BusinessLogDzd businessLog = dzdMapper.getUnStartOneRow();
            LambdaUpdateWrapper<BusinessLogDzd> wrapper = Wrappers.lambdaUpdate(BusinessLogDzd.class)
                    .set(BusinessLog::getTableStatus, 1)
                    .eq(BusinessLog::getId, businessLog.getId());
            dzdMapper.update(null, wrapper);
            parseTable(businessLog);
        }
    }

    public void fullParse() {
        while (true) {
            BusinessLog businessLog = businessLogMapper.getUnStartOneRow();
            LambdaUpdateWrapper<BusinessLog> wrapper = Wrappers.lambdaUpdate(BusinessLog.class)
                    .set(BusinessLog::getTableStatus, 1)
                    .eq(BusinessLog::getId, businessLog.getId());
            businessLogMapper.update(null, wrapper);
            parseTable(businessLog);
        }
    }

    private void parseTable(BusinessLog businessLog) {
        FileTableService fileTableService = fileTableFactory.get(businessLog.getFileName());
        fileTableService.toTable(businessLog);
    }
}
