package com.wenwan.web.controller.result;

import com.wenwan.api.result.ILogApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.result.LogVo;
import com.wenwan.model.result.SqlLogVo;
import com.wenwan.service.api.result.LogService;
import com.wenwan.web.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogController extends BaseController implements ILogApi {

    @Autowired
    private LogService logService;

    @Override
    public APIResponse<SearchResult<LogVo>> list(LogVo logVo) {
        return APIResponse.getOkJsonResult(logService.list(logVo));
    }

    @Override
    public APIResponse<SearchResult<SqlLogVo>> sqlLogList(SqlLogVo sqlLogVo) {
        return APIResponse.getOkJsonResult(logService.sqlLogList(sqlLogVo));
    }

    @Override
    public APIResponse<Void> reParse(String businessLog,Long businessLogId) {
        logService.reParse(businessLog,businessLogId);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<String> resultTable(String businessLog, Long fileId) {
        return APIResponse.getOkJsonResult(logService.resultTable(businessLog,fileId));
    }
}
