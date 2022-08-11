package com.wenwan.api.sort;

import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.sort.WsSourceFileSort;
import com.wenwan.model.WwSourceFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sort")
@Api("分拣列表")
public interface ISortApi {

    @PostMapping("/list")
    @ApiOperation("源文件列表")
    //todo 查询换新vo 补充页面条件
    APIResponse<SearchResult<WwSourceFile>> fileList(@RequestBody WwSourceFile searchResult);

    @PostMapping("/trigger")
    @ApiOperation("人工分拣")
    APIResponse<String> trigger(@RequestBody WsSourceFileSort sort);

}
