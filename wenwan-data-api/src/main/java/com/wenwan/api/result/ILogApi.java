package com.wenwan.api.result;

import com.wenwan.common.annotation.PassToken;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.request.ResultTableQuery;
import com.wenwan.model.parse.result.TargetTableResult;
import com.wenwan.model.result.LogVo;
import com.wenwan.model.result.SqlLogVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/log")
@Api(description = "运行日志相关api")
public interface ILogApi {
    @PostMapping("/list")
    @ApiOperation("运行日志")
    APIResponse<SearchResult<LogVo>> list(@RequestBody LogVo logVo);

    @PostMapping("/sqlLog/list")
    @ApiOperation("sql任务组运行日志")
    APIResponse<SearchResult<SqlLogVo>> sqlLogList(@RequestBody SqlLogVo sqlLogVo);

    @PostMapping("/re-parse/{businessLog}/{businessLogId}")
    @ApiOperation("重跑任务组")
    APIResponse<Void> reParse(@PathVariable("businessLog") String businessLog,@PathVariable("businessLogId") Long businessLogId);

    @PostMapping("/resultTable/page")
    @ApiOperation("结果表")
    APIResponse<TargetTableResult> resultTable(@RequestBody ResultTableQuery resultTableQuery);

    @GetMapping("/download/source/file")
    @PassToken
    ResponseEntity<Resource> downloadFile(@RequestParam String businessLog, @RequestParam Long businessLogId);
}
