package com.wenwan.api.parse;

import com.wenwan.common.api.APIResponse;
import com.wenwan.model.parse.ColumnInfoVo;
import com.wenwan.model.parse.TableInfoVo;
import com.wenwan.model.parse.WwDataParseRule;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api/v1/parse/model")
public interface IModelDesignApi {

    @PutMapping("/table/insert")
    @ApiOperation("新增表信息")
    APIResponse<Void> insertTable(@RequestBody TableInfoVo tableInfoVo);

    @PostMapping("/table/update")
    @ApiOperation("新增表信息")
    APIResponse<Void> updateTable(@RequestBody TableInfoVo tableInfoVo);

    @DeleteMapping("/table/delete/{id}")
    @ApiOperation("删除表信息")
    APIResponse<Void> deleteTable(@PathVariable Long id);

    @PostMapping("/table/query")
    @ApiOperation("表list")
    APIResponse<List<TableInfoVo>> queryTable(@RequestBody TableInfoVo tableInfoVo);

    @PutMapping("/column/insert")
    @ApiOperation("新增字段信息")
    APIResponse<Void> insertColumn(@RequestBody List<ColumnInfoVo> columnInfoVos);

    @PostMapping("/column/update")
    @ApiOperation("新增字段信息")
    APIResponse<Void> updateColumn(@RequestBody List<ColumnInfoVo> columnInfoVo);

    @PostMapping("/column/update")
    @ApiOperation("字段list")
    APIResponse<List<ColumnInfoVo>> queryColumn(@RequestBody ColumnInfoVo columnInfoVo);

    @PostMapping("/column/generate")
    @ApiOperation("生成字段信息(excel)")
    APIResponse<List<ColumnInfoVo>> generateColumn(@RequestParam MultipartFile file);
}
