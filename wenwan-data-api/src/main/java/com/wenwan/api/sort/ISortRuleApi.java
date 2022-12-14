package com.wenwan.api.sort;

import com.wenwan.common.annotation.PassToken;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.sort.LabelVo;
import com.wenwan.model.sort.SortRuleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "分拣规则相关api")
@RequestMapping("/api/v1/sort/rule")
public interface ISortRuleApi {

    @PostMapping("/insert")
    @ApiOperation("创建分拣规则")
    APIResponse<String> insert(@RequestBody SortRuleVo sortRuleVo);

    @PostMapping("/update")
    @ApiOperation("修改分拣规则")
    APIResponse<String> update(@RequestBody SortRuleVo sortRuleVo);

    @PostMapping("/list")
    @ApiOperation("分拣规则列表")
    APIResponse<SearchResult<SortRuleVo>> list(@RequestBody SortRuleVo sortRuleVo);

    @DeleteMapping("/delete")
    @ApiOperation("删除解析规则")
    APIResponse<String> delete(@RequestParam Long id);

    @PostMapping("/label/list")
    @ApiOperation("分类列表")
    @PassToken
    APIResponse<List<LabelVo>> labelList(@RequestBody LabelVo labelVo);
}
