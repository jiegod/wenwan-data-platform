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
    private static final ExecutorService targetTableThreadPool = Executors.newFixedThreadPool(10);

    @Autowired
    private GenerateTargetTableService parseTableService;

    @XxlJob(value = "parseGenerateTargetTableHandler")
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log.info("parse generate target table job run, param: {}", param);
        XxlJobLogger.log("XXL-JOB-ANNOTATION, parseTableHandler.");
        //不指定参数全量跑
        if (StringUtils.isEmpty(param)) {
            targetTableThreadPool.submit(() -> {
                parseTableService.cnsjFullParse();
            });
            targetTableThreadPool.submit(() -> {
                parseTableService.cwjzFullParse();
            });
            targetTableThreadPool.submit(() -> {
                parseTableService.cwqrdFullParse();
            });
            targetTableThreadPool.submit(() -> {
                parseTableService.cwyspFullParse();
            });
            targetTableThreadPool.submit(() -> {
                parseTableService.dwbzjFullParse();
            });
            targetTableThreadPool.submit(() -> {
                parseTableService.dzdFullParse();
            });
        } else {
            if ("cnsj".equals(param)) {
                targetTableThreadPool.submit(() -> {
                    parseTableService.cnsjFullParse();
                });
            }
            if ("cwjz".equals(param)) {
                targetTableThreadPool.submit(() -> {
                    parseTableService.cwjzFullParse();
                });
            }
            if ("cwqrd".equals(param)) {
                targetTableThreadPool.submit(() -> {
                    parseTableService.cwqrdFullParse();
                });
            }
            if ("cwysp".equals(param)) {
                targetTableThreadPool.submit(() -> {
                    parseTableService.cwyspFullParse();
                });
            }
            if ("dwbzj".equals(param)) {
                targetTableThreadPool.submit(() -> {
                    parseTableService.dwbzjFullParse();
                });
            }
            if ("dzd".equals(param)) {
                targetTableThreadPool.submit(() -> {
                    parseTableService.dzdFullParse();
                });
            }
        }
        return ReturnT.SUCCESS;
    }

}
