package com.wenwan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import com.wenwan.common.constant.MysqlValueType;
import com.wenwan.mysql.dao.entity.BusinessLog;
import com.wenwan.mysql.dao.entity.ColumnInfo;
import com.wenwan.mysql.dao.entity.ParseTableMapping;
import com.wenwan.mysql.dao.entity.TableInfo;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.common.FileTableService;
import com.wenwan.service.util.TransactionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ExcelFileTableServiceImpl extends MapperConfigService implements FileTableService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private TransactionUtil transactional;

    @Override
    public boolean accept(String fileName) {
        return fileName.endsWith(".xlsx");
    }

    @Override
    public void toTable(BusinessLog businessLog) {
        try {
            List<Long> tableIds = getTableIds(businessLog.getParseRuleId());
            for (int i = 0; i < tableIds.size(); i++) {
                Long tableId = tableIds.get(i);
                TableInfo tableInfo = tableInfoMapper.selectById(tableId);
                generateExcelToTable(String.valueOf(businessLog.getFileId()), tableInfo.getDbName()+ "." + tableInfo.getTableName(), businessLog.getFilePath());
            }
        }catch (Exception e) {
            log.error("ExcelFileTableServiceImpl.toTable error",e);
            throw new RuntimeException(e);
        }
    }

    private void generateExcelToTable(String fileId, String tableName, String excelFilePath) throws IOException {
        excelUtils.excelToMysql(fileId, tableName, excelFilePath);
    }


    private List<Long> getTableIds(Long parseRuleId){
        LambdaQueryWrapper<ParseTableMapping> wrapper = Wrappers.lambdaQuery(ParseTableMapping.class)
                .eq(ParseTableMapping::getParseRuleId,parseRuleId)
                .orderByAsc(ParseTableMapping::getOrder);
        List<ParseTableMapping> parseTableMappings = parseTableMappingMapper.selectList(wrapper);
        return parseTableMappings.stream().map(ParseTableMapping::getTableId).collect(Collectors.toList());
    }


}
