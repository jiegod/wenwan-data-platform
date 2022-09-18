package com.wenwan.service.xxljob;

import com.wenwan.service.api.sort.SortService;
import com.wenwan.service.util.StringDateUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FileSortHandler extends IJobHandler {

    @Autowired
    private SortService sortService;

    @Override
    @XxlJob(value = "fileSortHandler")
    public ReturnT<String> execute(String param) throws Exception {
        log.info("my first annotation job run, param: {}", param);
        sortService.autoTrigger(StringDateUtil.getToday());
        XxlJobLogger.log("XXL-JOB-ANNOTATION, myJobAnnotationHandler.");
        return null;
    }

}
