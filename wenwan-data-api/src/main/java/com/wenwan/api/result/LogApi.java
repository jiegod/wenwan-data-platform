package com.wenwan.api.result;

import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.result.LogVo;
import com.wenwan.model.result.SqlLogVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/log")
@Api("日志列表")
public interface LogApi {
    @PostMapping("/list")
    @ApiOperation("运行日志")
    APIResponse<SearchResult<LogVo>> list(@RequestBody LogVo logVo);

    @PostMapping("/sqlLog/list")
    @ApiOperation("sql任务组运行日志")
    APIResponse<SearchResult<SqlLogVo>> sqlLogList(@RequestBody SqlLogVo sqlLogVo);
}
