package com.wenwan.web.controller.parse;

import com.wenwan.api.parse.ITableApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.ColumnInfoVo;
import com.wenwan.model.parse.ParseTableMappingVo;
import com.wenwan.model.parse.TableInfoVo;
import com.wenwan.service.api.parse.TableService;
import com.wenwan.web.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@Slf4j
public class TableController extends BaseController implements ITableApi {

    @Autowired
    private TableService tableService;

    @Override
    public APIResponse<String> parseTableMapping(List<ParseTableMappingVo> tableInfoVos) {
        tableService.parseTableMapping(tableInfoVos);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<String> insertTable(TableInfoVo tableInfoVo) {
        tableService.insertTable(tableInfoVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<String> updateTable(TableInfoVo tableInfoVo) {
        tableService.updateTable(tableInfoVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<String> deleteTable(Long id) {
        tableService.deleteTable(id);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<SearchResult<TableInfoVo>> tableList(TableInfoVo tableInfoVo) {
        return APIResponse.getOkJsonResult(tableService.tableList(tableInfoVo));
    }

    @Override
    public APIResponse<Set<String>> getTableNameList() {
        return APIResponse.getOkJsonResult(tableService.tableList());
    }

    @Override
    public APIResponse<Set<String>> getDbNameList() {
        return APIResponse.getOkJsonResult(tableService.dbList());
    }

    @Override
    public APIResponse<String> insertColumn(List<ColumnInfoVo> columnInfoVos) {
        tableService.insertColumn(columnInfoVos);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<String> deleteColumn(Long id) {
        tableService.deleteColumn(id);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<String> updateColumn(List<ColumnInfoVo> columnInfoVos) {
        tableService.updateColumn(columnInfoVos);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<SearchResult<ColumnInfoVo>> columnList(ColumnInfoVo columnInfoVo) {
        return APIResponse.getOkJsonResult(tableService.columnList(columnInfoVo));
    }

    @Override
    public APIResponse<String> generateDDL(Long tableId) {
        return APIResponse.getOkJsonResult(tableService.generateDDL(tableId));
    }
}
