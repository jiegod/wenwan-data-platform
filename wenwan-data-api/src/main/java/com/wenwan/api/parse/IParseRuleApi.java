package com.wenwan.api.parse;

import com.wenwan.common.annotation.PassToken;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.FileTypeVo;
import com.wenwan.model.parse.ParseRuleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parse/rule")
@Api(description = "解析规则配置相关api")
public interface IParseRuleApi {

    @PostMapping("/insert")
    @ApiOperation("创建分拣规则")
    APIResponse<Void> insert(@RequestBody ParseRuleVo parseRule);

    @DeleteMapping("/delete")
    @ApiOperation("删除解析规则")
    APIResponse<Void> delete(@RequestParam Long id);

    @PostMapping("/update")
    @ApiOperation("修改分拣规则")
    APIResponse<Void> update(@RequestBody ParseRuleVo parseRule);

    @PostMapping("/list")
    @ApiOperation("分拣规则列表")
    APIResponse<SearchResult<ParseRuleVo>> list(@RequestBody ParseRuleVo parseRule);

    @PostMapping("/fileType/list")
    @ApiOperation("文件类型列表")
    @PassToken
    APIResponse<List<FileTypeVo>> fileTypeList(@RequestBody FileTypeVo fileTypeVo);


}
