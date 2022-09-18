package com.wenwan.service.xxljob;

import com.wenwan.model.enums.Datasource;
import com.wenwan.service.api.parse.ParseService;
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

    @Autowired
    private ParseService parseService;

    //todo 单线程处理，后续加上redis锁
    @Override
    @XxlJob(value = "emailParseHandler")
    public ReturnT<String> execute(String param){
        log.info("email parse job run, param: {},port:{}", param, xxlJobConfig.getPort());
        XxlJobLogger.log("XXL-JOB-ANNOTATION, emailParseHandler.");
        //param 就是 labels(逗号分隔),如果 param 不传,执行所有label
        parseService.fullParse(Datasource.MAIL,param);
        return ReturnT.SUCCESS;
    }

    //todo 加载失败的需要补偿

}
