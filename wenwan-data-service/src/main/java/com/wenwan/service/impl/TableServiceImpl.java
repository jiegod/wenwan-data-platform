package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenwan.common.api.SearchResult;
import com.wenwan.common.exception.BusinessException;
import com.wenwan.mysql.dao.entity.ColumnInfo;
import com.wenwan.mysql.dao.entity.ParseRule;
import com.wenwan.mysql.dao.entity.ParseTableMapping;
import com.wenwan.mysql.dao.entity.TableInfo;
import com.wenwan.model.parse.ColumnInfoVo;
import com.wenwan.model.parse.ParseTableMappingVo;
import com.wenwan.model.parse.TableInfoVo;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.parse.TableService;
import com.wenwan.service.util.DDLGenerator;
import com.wenwan.service.util.StringDateUtil;
import com.wenwan.service.util.UserStorage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TableServiceImpl extends MapperConfigService<TableInfo, TableInfoVo> implements TableService {

    @Autowired
    private DDLGenerator ddlGenerator;

    @Override
    public void parseTableMapping(List<ParseTableMappingVo> tableInfoVos) {
        ParseTableMappingVo.paramCheck(tableInfoVos);
        Long parseRuleId = tableInfoVos.get(0).getParseRuleId();
        LambdaQueryWrapper<ParseTableMapping> wrapper = Wrappers.lambdaQuery(ParseTableMapping.class)
                .eq(ParseTableMapping::getParseRuleId, parseRuleId);
        parseTableMappingMapper.delete(wrapper);
        tableInfoVos.forEach(parseTableMappingVo -> {
            ParseTableMapping parseTableMapping = new ParseTableMapping();
            BeanUtils.copyProperties(parseTableMappingVo, parseTableMapping);
            parseTableMapping.setOperator(UserStorage.get());
            parseTableMapping.setOperationDate(StringDateUtil.getToday());
            parseTableMappingMapper.insert(parseTableMapping);
        });
    }

    @Override
    @Transactional
    public void insertTable(TableInfoVo tableInfoVo) {
        TableInfo tableInfo = new TableInfo();
        BeanUtils.copyProperties(tableInfoVo, tableInfo);
        tableInfo.setOperator(UserStorage.get());
        tableInfo.setOperationDate(StringDateUtil.getToday());
        tableInfoMapper.insert(tableInfo);

        insertColumn(ColumnInfoVo.defaultColumn(tableInfo.getId(), tableInfoVo.getOperator()));
    }

    @Override
    public void updateTable(TableInfoVo tableInfoVo) {
        TableInfo tableInfo = new TableInfo();
        BeanUtils.copyProperties(tableInfoVo, tableInfo);
        tableInfo.setOperator(UserStorage.get());
        tableInfo.setOperationDate(StringDateUtil.getToday());
        tableInfoMapper.updateById(tableInfo);
    }

    @Override
    public void deleteTable(Long id) {
        tableInfoMapper.deleteById(id);
    }

    @Override
    public SearchResult<TableInfoVo> tableList(TableInfoVo tableInfoVo) {
        List<Long> tableIds = null;
        if (tableInfoVo.getParseRuleId() != null) {
            LambdaQueryWrapper<ParseTableMapping> queryWrapper = Wrappers.lambdaQuery(ParseTableMapping.class)
                    .eq(ParseTableMapping::getParseRuleId, tableInfoVo.getParseRuleId())
                    .select(ParseTableMapping::getTableId);
            tableIds = parseTableMappingMapper.selectList(queryWrapper).stream().map(ParseTableMapping::getTableId).collect(Collectors.toList());
        }
        Page<TableInfo> page = new Page<>(tableInfoVo.getPageNo(), tableInfoVo.getPageSize());
        LambdaQueryWrapper<TableInfo> wrapper = Wrappers.lambdaQuery(TableInfo.class);
        if (CollectionUtils.isNotEmpty(tableIds)) {
            wrapper.in(TableInfo::getId, tableIds);
        }
        addFilter(wrapper, tableInfoVo);
        tableInfoMapper.selectPage(page, wrapper);
        List<TableInfoVo> rows = page.getRecords().stream().map(tableInfo -> {
            TableInfoVo resultVo = new TableInfoVo();
            BeanUtils.copyProperties(tableInfo, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(rows, page.getTotal());
    }

    @Override
    public void insertColumn(List<ColumnInfoVo> columnInfoVos) {
        if (CollectionUtils.isEmpty(columnInfoVos)) {
            log.info("[insertColumn] param empty");
            throw new BusinessException("param is empty");
        }
        ColumnInfoVo.paramCheck(columnInfoVos);
        TableInfo tableInfo = tableInfoMapper.selectById(columnInfoVos.get(0).getTableId());
        if (tableInfo == null) {
            throw new BusinessException("table is not exit, please check it");
        }
        columnInfoVos.forEach(columnInfoVo -> {
            insertThreadPool.submit(() -> {
                ColumnInfo columnInfo = new ColumnInfo();
                BeanUtils.copyProperties(columnInfoVo, columnInfo);
                columnInfo.setOperator(UserStorage.get());
                columnInfo.setOperationDate(StringDateUtil.getToday());
                columnInfoMapper.insert(columnInfo);
            });
        });
    }

    @Override
    public void deleteColumn(Long id) {
        columnInfoMapper.deleteById(id);
    }

    @Override
    public void updateColumn(List<ColumnInfoVo> columnInfoVos) {
        LambdaQueryWrapper<ColumnInfo> wrapper = Wrappers.lambdaQuery(ColumnInfo.class).
                eq(ColumnInfo::getTableId, columnInfoVos.get(0).getTableId());
        columnInfoMapper.delete(wrapper);
        columnInfoVos.forEach(columnInfoVo -> {
            insertThreadPool.submit(() -> {
                ColumnInfo columnInfo = new ColumnInfo();
                BeanUtils.copyProperties(columnInfoVo, columnInfo);
                columnInfo.setOperator(UserStorage.get());
                columnInfo.setOperationDate(StringDateUtil.getToday());
                columnInfoMapper.insert(columnInfo);
            });
        });
    }

    @Override
    public SearchResult<ColumnInfoVo> columnList(ColumnInfoVo columnInfoVo) {
        Page<ColumnInfo> page = new Page<>(columnInfoVo.getPageNo(), columnInfoVo.getPageSize());
        LambdaQueryWrapper<ColumnInfo> wrapper = Wrappers.lambdaQuery(ColumnInfo.class).eq(ColumnInfo::getTableId, columnInfoVo.getTableId());
        columnInfoMapper.selectPage(page, wrapper);
        List<ColumnInfoVo> rows = page.getRecords().stream().map(columnInfo -> {
            ColumnInfoVo resultVo = new ColumnInfoVo();
            BeanUtils.copyProperties(columnInfo, resultVo);
            return resultVo;
        }).collect(Collectors.toList());
        return new SearchResult<>(rows, page.getTotal());
    }

    @Override
    public String generateDDL(Long tableId) {
        TableInfo tableInfo = tableInfoMapper.selectById(tableId);
        if (tableInfo == null) {
            throw new BusinessException("table is not exit, please check it");
        }
        LambdaQueryWrapper<ColumnInfo> wrapper = Wrappers.lambdaQuery(ColumnInfo.class).eq(ColumnInfo::getTableId, tableId);
        List<ColumnInfo> columns = columnInfoMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(columns)) {
            throw new BusinessException("column is not exit, please check it");
        }
        return ddlGenerator.makeCreateTableDDL(columns, tableInfo);
    }

    @Override
    public Set<String> dbList() {
        Set<String> result = tableInfoMapper.selectList(Wrappers.lambdaQuery(TableInfo.class).select(TableInfo::getDbName)).stream().map(TableInfo::getDbName).collect(Collectors.toSet());
        return result;
    }

    @Override
    public Set<String> tableList() {
        Set<String> result = tableInfoMapper.selectList(Wrappers.lambdaQuery(TableInfo.class).select(TableInfo::getTableName)).stream().map(TableInfo::getTableName).collect(Collectors.toSet());
        return result;
    }

    @Override
    protected void addFilter(LambdaQueryWrapper<TableInfo> wrapper, TableInfoVo tableInfoVo) {
        if (StringUtils.isNotEmpty(tableInfoVo.getSearch())){
            wrapper.like(TableInfo::getTableName, tableInfoVo.getSearch());
        }
        if (StringUtils.isNotEmpty(tableInfoVo.getTableName())){
            wrapper.like(TableInfo::getTableName, tableInfoVo.getSearch());
        }
        if (StringUtils.isNotEmpty(tableInfoVo.getDbName())){
            wrapper.like(TableInfo::getDbName, tableInfoVo.getSearch());
        }
    }
}
