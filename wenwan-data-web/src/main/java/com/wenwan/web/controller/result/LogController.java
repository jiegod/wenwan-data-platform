package com.wenwan.web.controller.result;

import com.wenwan.api.result.ILogApi;
import com.wenwan.common.annotation.PassToken;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.request.ResultTableQuery;
import com.wenwan.model.parse.result.TargetTableResult;
import com.wenwan.model.result.LogVo;
import com.wenwan.model.result.SqlLogVo;
import com.wenwan.service.api.result.LogService;
import com.wenwan.web.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
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
    public APIResponse<TargetTableResult> resultTable(ResultTableQuery resultTableQuery) {
        return APIResponse.getOkJsonResult(logService.resultTable(resultTableQuery));
    }

    @Override
    @PassToken
    public ResponseEntity<Resource> downloadFile(String businessLog, Long businessLogId) {
        return logService.downloadFile(businessLog, businessLogId);
    }
}
