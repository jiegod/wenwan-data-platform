package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.mysql.dao.entity.*;
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
            if (businessLog == null) {
                return;
            }
            try {
                LambdaUpdateWrapper<BusinessLogCnsj> wrapper = Wrappers.lambdaUpdate(BusinessLogCnsj.class)
                        .set(BusinessLog::getTableStatus, 1)
                        .eq(BusinessLog::getId, businessLog.getId());
                cnsjMapper.update(null, wrapper);
                parseTable(businessLog);
                LambdaUpdateWrapper<BusinessLogCnsj> success = Wrappers.lambdaUpdate(BusinessLogCnsj.class)
                        .set(BusinessLog::getTableStatus, 2)
                        .eq(BusinessLog::getId, businessLog.getId());
                cnsjMapper.update(null, success);
            } catch (Exception e) {
                log.error("cnsjFullParse error.", e);
                LambdaUpdateWrapper<BusinessLogCnsj> wrapper = Wrappers.lambdaUpdate(BusinessLogCnsj.class)
                        .set(BusinessLog::getTableStatus, 3)
                        .eq(BusinessLog::getId, businessLog.getId());
                cnsjMapper.update(null, wrapper);
            }
        }
    }

    @Override
    public void cwjzFullParse() {
        while (true) {
            BusinessLogCwjz businessLog = cwjzMapper.getUnStartOneRow();
            if (businessLog == null) {
                return;
            }
            try {
                LambdaUpdateWrapper<BusinessLogCwjz> wrapper = Wrappers.lambdaUpdate(BusinessLogCwjz.class)
                        .set(BusinessLog::getTableStatus, 1)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwjzMapper.update(null, wrapper);
                LambdaUpdateWrapper<BusinessLogCwjz> success = Wrappers.lambdaUpdate(BusinessLogCwjz.class)
                        .set(BusinessLog::getTableStatus, 2)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwjzMapper.update(null, success);
                parseTable(businessLog);
            } catch (Exception e) {
                log.error("cwjzFullParse error.", e);
                LambdaUpdateWrapper<BusinessLogCwjz> wrapper = Wrappers.lambdaUpdate(BusinessLogCwjz.class)
                        .set(BusinessLog::getTableStatus, 3)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwjzMapper.update(null, wrapper);
            }
        }
    }

    @Override
    public void cwqrdFullParse() {
        while (true) {
            BusinessLogCwqrd businessLog = cwqrdMapper.getUnStartOneRow();
            if (businessLog == null) {
                return;
            }
            try {
                LambdaUpdateWrapper<BusinessLogCwqrd> wrapper = Wrappers.lambdaUpdate(BusinessLogCwqrd.class)
                        .set(BusinessLog::getTableStatus, 1)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwqrdMapper.update(null, wrapper);
                parseTable(businessLog);
                LambdaUpdateWrapper<BusinessLogCwqrd> success = Wrappers.lambdaUpdate(BusinessLogCwqrd.class)
                        .set(BusinessLog::getTableStatus, 2)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwqrdMapper.update(null, success);
            } catch (Exception e) {
                log.error("cwqrdFullParse error.", e);
                LambdaUpdateWrapper<BusinessLogCwqrd> wrapper = Wrappers.lambdaUpdate(BusinessLogCwqrd.class)
                        .set(BusinessLog::getTableStatus, 3)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwqrdMapper.update(null, wrapper);
            }
        }
    }

    @Override
    public void cwyspFullParse() {
        while (true) {
            BusinessLogCwysp businessLog = cwyspMapper.getUnStartOneRow();
            if (businessLog == null) {
                return;
            }
            try {
                LambdaUpdateWrapper<BusinessLogCwysp> wrapper = Wrappers.lambdaUpdate(BusinessLogCwysp.class)
                        .set(BusinessLog::getTableStatus, 1)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwyspMapper.update(null, wrapper);
                parseTable(businessLog);
                LambdaUpdateWrapper<BusinessLogCwysp> success = Wrappers.lambdaUpdate(BusinessLogCwysp.class)
                        .set(BusinessLog::getTableStatus, 2)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwyspMapper.update(null, success);
            } catch (Exception e) {
                log.error("cwyspFullParse error.", e);
                LambdaUpdateWrapper<BusinessLogCwysp> wrapper = Wrappers.lambdaUpdate(BusinessLogCwysp.class)
                        .set(BusinessLog::getTableStatus, 3)
                        .eq(BusinessLog::getId, businessLog.getId());
                cwyspMapper.update(null, wrapper);
            }
        }
    }

    @Override
    public void dwbzjFullParse() {
        while (true) {
            BusinessLogDwbzj businessLog = dwbzjMapper.getUnStartOneRow();
            if (businessLog == null) {
                return;
            }
            try {
                LambdaUpdateWrapper<BusinessLogDwbzj> wrapper = Wrappers.lambdaUpdate(BusinessLogDwbzj.class)
                        .set(BusinessLog::getTableStatus, 1)
                        .eq(BusinessLog::getId, businessLog.getId());
                dwbzjMapper.update(null, wrapper);
                LambdaUpdateWrapper<BusinessLogDwbzj> success = Wrappers.lambdaUpdate(BusinessLogDwbzj.class)
                        .set(BusinessLog::getTableStatus, 2)
                        .eq(BusinessLog::getId, businessLog.getId());
                dwbzjMapper.update(null, success);
                parseTable(businessLog);
            } catch (Exception e) {
                log.error("dwbzjFullParse error.", e);
                LambdaUpdateWrapper<BusinessLogDwbzj> wrapper = Wrappers.lambdaUpdate(BusinessLogDwbzj.class)
                        .set(BusinessLog::getTableStatus, 3)
                        .eq(BusinessLog::getId, businessLog.getId());
                dwbzjMapper.update(null, wrapper);
            }
        }
    }

    @Override
    public void dzdFullParse() {
        while (true) {
            BusinessLogDzd businessLog = dzdMapper.getUnStartOneRow();
            if (businessLog == null) {
                return;
            }
            try {
                LambdaUpdateWrapper<BusinessLogDzd> wrapper = Wrappers.lambdaUpdate(BusinessLogDzd.class)
                        .set(BusinessLog::getTableStatus, 1)
                        .eq(BusinessLog::getId, businessLog.getId());
                dzdMapper.update(null, wrapper);
                parseTable(businessLog);
                LambdaUpdateWrapper<BusinessLogDzd> success = Wrappers.lambdaUpdate(BusinessLogDzd.class)
                        .set(BusinessLog::getTableStatus, 2)
                        .eq(BusinessLog::getId, businessLog.getId());
                dzdMapper.update(null, success);
            } catch (Exception e) {
                log.error("dzdFullParse error.", e);
                LambdaUpdateWrapper<BusinessLogDzd> wrapper = Wrappers.lambdaUpdate(BusinessLogDzd.class)
                        .set(BusinessLog::getTableStatus, 3)
                        .eq(BusinessLog::getId, businessLog.getId());
                dzdMapper.update(null, wrapper);
            }
        }
    }

    private void parseTable(BusinessLog businessLog) {
        FileTableService fileTableService = fileTableFactory.get(businessLog.getFileName());
        fileTableService.toTable(businessLog);
    }
}
