package com.wenwan.service.xxljob;

import com.wenwan.service.api.parse.ParseTableService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ParseTableHandler extends IJobHandler {
    @Autowired
    private XxlJobConfig xxlJobConfig;

    @Autowired
    private ParseTableService parseTableService;

    //todo 单线程处理，后续加上redis锁
    @XxlJob(value = "parseTableHandler")
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log.info("parse table job run, param: {},port:{}", param, xxlJobConfig.getPort());
        XxlJobLogger.log("XXL-JOB-ANNOTATION, parseTableHandler.");
        parseTableService.fullParse();
        return ReturnT.SUCCESS;
    }

    //todo 失败的需要补偿
}
