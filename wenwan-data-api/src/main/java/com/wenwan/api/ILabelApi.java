package com.wenwan.api;

import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.LabelQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/label")
@Api(description = "分类api")
public interface ILabelApi {

    @PostMapping("/list")
    @ApiOperation("分类列表")
    APIResponse<SearchResult<String>> list(@RequestBody LabelQuery query);

}
