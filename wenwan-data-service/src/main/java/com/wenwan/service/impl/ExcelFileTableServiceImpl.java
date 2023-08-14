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
            FileInputStream fis = new FileInputStream(businessLog.getFilePath());
            Workbook workbook = new XSSFWorkbook(fis);
            List<Long> tableIds = getTableIds(businessLog.getParseRuleId());
            List<String> insertSqlList= Lists.newArrayList();
            for (int i = 0; i < tableIds.size(); i++) {
                Long tableId = tableIds.get(i);
                TableInfo tableInfo = tableInfoMapper.selectById(tableId);
                StringBuffer insertSql=new StringBuffer().append("insert into "+tableInfo.getDbName()+"."+tableInfo.getTableName());

                LambdaQueryWrapper<ColumnInfo> wrapper = Wrappers.lambdaQuery(ColumnInfo.class)
                        .eq(ColumnInfo::getTableId, tableId)
                        .orderByAsc(ColumnInfo::getName);
                List<ColumnInfo> columnInfos = columnInfoMapper.selectList(wrapper);
                insertSql.append(" (");
                insertSql.append(columnInfos.stream().map(ColumnInfo::getName).collect(Collectors.joining(",")));
                insertSql.append(") values ");

                Sheet sheet = workbook.getSheetAt(i);
                for (Row row:sheet) {
                    insertSql.append("(");
                    for (int j=0;j<columnInfos.size();j++) {
                        ColumnInfo columnInfo = columnInfos.get(j);
                        Cell cell = row.getCell(j);
                        insertSql.append(getValue(columnInfo,cell)+",");
                    }
                    insertSql.deleteCharAt(insertSql.length()-1);
                    insertSql.append("),");
                }
                String temp = insertSql.toString();
                insertSqlList.add(temp.substring(0,temp.length()-1)+";");
            }
            //todo 后续改成批量插入
            transactional.transactional(s->insertSqlList.forEach(insertSql-> sqlSessionTemplate.insert(insertSql)));
        }catch (Exception e) {
            businessLog.setTableStatus(2);
            businessLogMapper.updateById(businessLog);
            log.error("ExcelFileTableServiceImpl.toTable error",e);
            throw new RuntimeException(e);
        }
    }

    private String getValue(ColumnInfo columnInfo, Cell cell) {
        MysqlValueType mysqlValueType = MysqlValueType.get(columnInfo.getType().toUpperCase());
        if(mysqlValueType.getType()==1){
            return "'"+cell.getStringCellValue()+"'";
        }
        if(mysqlValueType.getType()==2){
            return cell.getStringCellValue();
        }
        return "null";
    }


    private List<Long> getTableIds(Long parseRuleId){
        LambdaQueryWrapper<ParseTableMapping> wrapper = Wrappers.lambdaQuery(ParseTableMapping.class)
                .eq(ParseTableMapping::getParseRuleId,parseRuleId)
                .orderByAsc(ParseTableMapping::getOrder);
        List<ParseTableMapping> parseTableMappings = parseTableMappingMapper.selectList(wrapper);
        return parseTableMappings.stream().map(ParseTableMapping::getTableId).collect(Collectors.toList());
    }


}
