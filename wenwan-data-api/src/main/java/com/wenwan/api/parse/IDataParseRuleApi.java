package com.wenwan.api.parse;

import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.WwDataParseRule;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/parse/rule")
public interface IDataParseRuleApi {

    @PostMapping("/insert")
    @ApiOperation("创建分拣规则")
    APIResponse<String> insert(@RequestBody WwDataParseRule parseRule);

    @DeleteMapping("/delete")
    @ApiOperation("删除解析规则")
    APIResponse<String> delete(@RequestParam Long id);

    @PostMapping("/update")
    @ApiOperation("修改分拣规则")
    APIResponse<String> update(@RequestBody WwDataParseRule parseRule);

    @PostMapping("/list")
    @ApiOperation("分拣规则列表")
    APIResponse<SearchResult<WwDataParseRule>> list(@RequestBody WwDataParseRule parseRule);


}
