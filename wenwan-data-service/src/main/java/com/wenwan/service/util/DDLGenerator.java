package com.wenwan.service.util;

import com.wenwan.dao.entity.ColumnInfo;
import com.wenwan.dao.entity.TableInfo;
import com.wenwan.service.constant.DDLConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class DDLGenerator implements DDLConstant {

    @Value("${metadata.table.ddl.tpl:}")
    protected String ddlTpl;

    public String makeCreateTableDDL(List<ColumnInfo> columns, TableInfo tableInfo){
        String fields = getFieldList(columns);
        String tableComment = getTableComment(tableInfo.getDbName(), tableInfo.getTableName(), tableInfo.getComment());
        String ddl = ddlTpl.replace(PLACEHOLDER_DB_NAME, tableInfo.getDbName())
                .replace(PLACEHOLDER_TABLE_NAME, tableInfo.getTableName())
                .replace(PLACEHOLDER_FIELD_LIST, fields)
                .replace(PLACEHOLDER_TABLE_COMMENT, tableComment);
        return ddl;
    }

    private String getFieldList(List<ColumnInfo> columns){
        String fields = columns.stream().map(columnInfo -> String.format(DDL_FIELD_TPL, columnInfo.getName(), columnInfo.getType(), columnInfo.getLength(), columnInfo.getComment()))
                .collect(Collectors.joining(DDL_FIELD_SEPARATOR));
        return String.format("%s%s", DDL_FIELD_PREFIX, fields);
    }

    private String getTableComment(String dbName, String tableName, String customComment){
        if (StringUtils.isNotEmpty(customComment)){
            return customComment.trim();
        }
        return String.format("%s.%s from wenwan platform", dbName, tableName);
    }
}
