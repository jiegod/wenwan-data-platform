package com.wenwan.api.sort;

import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.sort.WwSortRule;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("分拣规则")
@RequestMapping("/api/v1/sort/rule")
public interface ISortRuleApi {

    @PostMapping("/insert")
    @ApiOperation("创建分拣规则")
    APIResponse<String> insert(@RequestBody WwSortRule sortRule);

    @PostMapping("/update")
    @ApiOperation("修改分拣规则")
    APIResponse<String> update(@RequestBody WwSortRule sortRule);

    @PostMapping("/list")
    @ApiOperation("分拣规则列表")
    APIResponse<SearchResult<WwSortRule>> list(@RequestBody WwSortRule sortRule);

    @DeleteMapping("/delete")
    @ApiOperation("删除解析规则")
    APIResponse<String> delete(@RequestParam Long id);
}
