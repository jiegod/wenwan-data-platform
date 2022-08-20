package com.wenwan.api.sort;

import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.dto.SourceFileDto;
import com.wenwan.model.dto.TriggerSortDto;
import com.wenwan.model.request.sort.SourceFileRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sort")
@Api("分拣列表")
public interface ISortApi {

    @PostMapping("/list")
    @ApiOperation("源文件列表")
    APIResponse<SearchResult<SourceFileDto>> fileList(@RequestBody SourceFileRequest searchRequest);

    @PostMapping("/trigger")
    @ApiOperation("人工分拣")
    APIResponse<String> trigger(@RequestBody TriggerSortDto sort);

    @PostMapping("/detail")
    //todo 暂时先不做
    APIResponse<SourceFileDto> detail(@RequestParam Long id);

}
