package com.wenwan.api.parse;

import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.ColumnInfoVo;
import com.wenwan.model.parse.ParseTableMappingVo;
import com.wenwan.model.parse.TableInfoVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/parse/table")
public interface ITableApi {
    @PostMapping("/mapping")
    @ApiOperation("修改解析规则的落地表关联")
    APIResponse<Void> parseTableMapping(@RequestBody List<ParseTableMappingVo> tableInfoVos);

    @PutMapping("/table/insert")
    @ApiOperation("新增表信息")
    APIResponse<Void> insertTable(@RequestBody TableInfoVo tableInfoVo);

    @PostMapping("/table/update")
    @ApiOperation("修改表信息")
    APIResponse<Void> updateTable(@RequestBody TableInfoVo tableInfoVo);

    @DeleteMapping("/table/delete/{id}")
    @ApiOperation("删除表信息")
    APIResponse<Void> deleteTable(@PathVariable Long id);

    @PostMapping("/table/list")
    @ApiOperation("表list")
    APIResponse<SearchResult<TableInfoVo>> tableList(@RequestBody TableInfoVo tableInfoVo);

    @PutMapping("/column/insert")
    @ApiOperation("新增字段信息")
    APIResponse<Void> insertColumn(@RequestBody List<ColumnInfoVo> columnInfoVos);

    @PostMapping("/column/update")
    @ApiOperation("修改字段信息")
    APIResponse<Void> updateColumn(@RequestBody List<ColumnInfoVo> columnInfoVos);

    @PostMapping("/column/list")
    @ApiOperation("字段list")
    APIResponse<SearchResult<ColumnInfoVo>> columnList(@RequestBody ColumnInfoVo columnInfoVo);

    @GetMapping("/ddl/generate/{tableId}")
    @ApiOperation("生成建表语句")
    APIResponse<String> generateDDL(@PathVariable Long tableId);
}
