package com.wenwan.service.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DataParseHandler extends IJobHandler {

    @Autowired
    private XxlJobConfig xxlJobConfig;

    @Override
    @XxlJob(value = "myJobAnnotationHandler")
    public ReturnT<String> execute(String param) throws Exception {
        log.info("my first annotation job run, param: {},port:{}", param, xxlJobConfig.getPort());
        XxlJobLogger.log("XXL-JOB-ANNOTATION, myJobAnnotationHandler.");
        return null;
    }

}
