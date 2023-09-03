package com.wenwan.service.xxljob;

import com.wenwan.service.api.parse.GenerateTargetTableService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Configuration
public class ParseGenerateTargetTableHandler extends IJobHandler {
    @Autowired
    private XxlJobConfig xxlJobConfig;

    @Autowired
    private GenerateTargetTableService parseTableService;

    @XxlJob(value = "parseGenerateTargetTableHandler")
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log.info("parse generate target table job run, param: {}", param);
        XxlJobLogger.log("XXL-JOB-ANNOTATION, parseTableHandler.");
        //不指定参数全量跑
        parseTableService.fullPath(param);
        return ReturnT.SUCCESS;
    }

}
