package com.wenwan.web.controller.result;

import com.wenwan.api.result.ILogApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.result.LogVo;
import com.wenwan.model.result.SqlLogVo;
import com.wenwan.web.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogController extends BaseController implements ILogApi {
    @Override
    public APIResponse<SearchResult<LogVo>> list(LogVo logVo) {
        return null;
    }

    @Override
    public APIResponse<SearchResult<SqlLogVo>> sqlLogList(SqlLogVo sqlLogVo) {
        return null;
    }
}
