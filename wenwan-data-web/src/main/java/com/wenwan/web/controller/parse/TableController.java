package com.wenwan.web.controller.parse;

import com.wenwan.api.parse.ITableApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.ColumnInfoVo;
import com.wenwan.model.parse.ParseTableMappingVo;
import com.wenwan.model.parse.TableInfoVo;
import com.wenwan.web.controller.BaseController;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TableController extends BaseController implements ITableApi {

    @Override
    public APIResponse<Void> parseTableMapping(List<ParseTableMappingVo> tableInfoVos) {
        return null;
    }

    @Override
    public APIResponse<Void> insertTable(TableInfoVo tableInfoVo) {
        return null;
    }

    @Override
    public APIResponse<Void> updateTable(TableInfoVo tableInfoVo) {
        return null;
    }

    @Override
    public APIResponse<Void> deleteTable(Long id) {
        return null;
    }

    @Override
    public APIResponse<SearchResult<TableInfoVo>> tableList(TableInfoVo tableInfoVo) {
        return null;
    }

    @Override
    public APIResponse<Void> insertColumn(List<ColumnInfoVo> columnInfoVos) {
        return null;
    }

    @Override
    public APIResponse<Void> updateColumn(List<ColumnInfoVo> columnInfoVos) {
        return null;
    }

    @Override
    public APIResponse<SearchResult<ColumnInfoVo>> columnList(ColumnInfoVo columnInfoVo) {
        return null;
    }

    @Override
    public APIResponse<String> generateDDL(Long tableId) {
        return null;
    }
}
