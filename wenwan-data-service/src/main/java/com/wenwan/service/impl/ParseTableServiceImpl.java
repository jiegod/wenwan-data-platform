package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.dao.entity.BusinessLog;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.parse.ParseTableService;
import com.wenwan.service.util.AsyncExecutor;
import com.wenwan.service.util.TransactionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ParseTableServiceImpl extends MapperConfigService implements ParseTableService {

    @Autowired
    private TransactionUtil transactionUtil;

    // todo 目前只实现全量加载，后续必须实现增量，需要记录游标
    @Override
    public void incrParse() {

    }

    @Override
    public void fullParse() {
        LambdaQueryWrapper<BusinessLog> wrapper = Wrappers.lambdaQuery(BusinessLog.class)
                .eq(BusinessLog::getLoadingStatus,1)
                .eq(BusinessLog::getTableStatus,0);
        List<BusinessLog> businessLogs = businessLogMapper.selectList(wrapper);
        List<Future<?>> futures = businessLogs.stream().map(businessLog -> parseTableThreadPool.submit(() -> {
            transactionUtil.transactional(s-> parseTable(businessLog));
        })).collect(Collectors.toList());
        AsyncExecutor.wait(futures);
    }

    private void parseTable(BusinessLog businessLog){

    }
}
