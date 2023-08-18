package com.wenwan.service.api.parse;

import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.ColumnInfoVo;
import com.wenwan.model.parse.ParseTableMappingVo;
import com.wenwan.model.parse.TableInfoVo;

import java.util.List;
import java.util.Set;

public interface TableService {
    void parseTableMapping(List<ParseTableMappingVo> tableInfoVos);

    void insertTable(TableInfoVo tableInfoVo);

    void updateTable(TableInfoVo tableInfoVo);

    void deleteTable(Long id);

    SearchResult<TableInfoVo> tableList(TableInfoVo tableInfoVo);

    void insertColumn(List<ColumnInfoVo> columnInfoVos);

    void deleteColumn(Long id);

    void updateColumn(List<ColumnInfoVo> columnInfoVos);

    SearchResult<ColumnInfoVo> columnList(ColumnInfoVo columnInfoVo);

    String generateDDL(Long tableId);

    Set<String> dbList();
    Set<String> tableList();
}
