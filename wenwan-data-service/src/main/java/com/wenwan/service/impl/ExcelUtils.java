package com.wenwan.service.impl;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Component
public class ExcelUtils {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void excelToMysql(String fileId, String mysqlTable, String excelFilePath) {
        try (FileInputStream fileInputStream = new FileInputStream(excelFilePath)) {
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int numberOfColumns = sheet.getRow(0).getLastCellNum(); // 假设所有行具有相同的列数

            String insertQuery = createInsertQuery(mysqlTable, numberOfColumns + 2);
            List<Object[]> data = readExcelData(fileId, sheet);
            jdbcTemplate.execute("delete from " + mysqlTable + " where file_id="+ fileId);
            jdbcTemplate.batchUpdate(insertQuery, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Object[] row = data.get(i);
                    for (int j = 0; j < row.length; j++) {
                        ps.setObject(j + 1, row[j]);
                    }
                }
                @Override
                public int getBatchSize() {
                    return data.size();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String createInsertQuery(String tableName, int numberOfColumns) {
        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " VALUES (");

        for (int i = 0; i < numberOfColumns; i++) {
            query.append(i == 0 ? "?" : ", ?");
        }

        query.append(");");
        return query.toString();
    }

    private static List<Object[]> readExcelData(String fileId , Sheet sheet) {
        List<Object[]> data = new ArrayList<>();

        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            List<Object> rowData = new ArrayList<>();
            rowData.add(fileId);
            rowData.add(rowIndex);

            for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                Cell cell = row.getCell(cellIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                switch (cell.getCellType()) {
                    case STRING:
                        rowData.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            rowData.add(new Timestamp(cell.getDateCellValue().getTime()));
                        } else {
                            rowData.add(cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        rowData.add(cell.getBooleanCellValue());
                        break;
                    default:
                        rowData.add(null);
                        break;
                }
            }

            data.add(rowData.toArray());
        }

        return data;
    }
}
