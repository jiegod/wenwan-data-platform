package com.wenwan.api.parse;

import com.wenwan.common.api.APIResponse;
import com.wenwan.model.parse.ColumnInfoVo;
import com.wenwan.model.parse.TableInfoVo;
import com.wenwan.model.parse.WwDataParseRule;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/parse/model")
public interface IModelDesignApi {

    @PutMapping("/insert/table")
    @ApiOperation("新增表信息")
    APIResponse<Void> insertTable(@RequestBody TableInfoVo tableInfoVo);

    @PostMapping("/update/table")
    @ApiOperation("新增表信息")
    APIResponse<Void> updateTable(@RequestBody TableInfoVo tableInfoVo);

    @DeleteMapping("/delete/table/{id}")
    @ApiOperation("删除表信息")
    APIResponse<Void> deleteTable(@PathVariable Long id);

    @PutMapping("/insert/column")
    @ApiOperation("新增列信息")
    APIResponse<Void> insertColumn(@RequestBody ColumnInfoVo columnInfoVo);

    @PostMapping("/update/column")
    @ApiOperation("新增列信息")
    APIResponse<Void> updateColumn(@RequestBody ColumnInfoVo columnInfoVo);
}
