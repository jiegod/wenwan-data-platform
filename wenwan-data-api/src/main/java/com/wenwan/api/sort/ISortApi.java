package com.wenwan.api.sort;

import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.sort.TriggerSortVo;
import com.wenwan.model.sort.SourceFileVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/sort")
@Api(description = "分拣列表相关api")
public interface ISortApi {

    @PostMapping("/list")
    @ApiOperation("源文件列表")
    APIResponse<SearchResult<SourceFileVo>> list(@RequestBody SourceFileVo sourceFileVo);

    @PostMapping("/trigger")
    @ApiOperation("人工分拣")
    APIResponse<String> trigger(@RequestBody @Valid TriggerSortVo triggerSortVo);
}
