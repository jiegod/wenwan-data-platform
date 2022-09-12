package com.wenwan.service.constant;

public interface DDLConstant {
    String PLACEHOLDER_DB_NAME = "@@dbName@@";
    String PLACEHOLDER_TABLE_NAME = "@@TableName@@";
    String PLACEHOLDER_FIELD_LIST = "@@fieldList@@";
    String PLACEHOLDER_TABLE_COMMENT = "@@tableComment@@";

    String DDL_FIELD_TPL = "`%s` %s(%s) COMMENT '%s'";
    String DDL_FIELD_PREFIX = "\t";
    String DDL_FIELD_SEPARATOR = ",\n" + DDL_FIELD_PREFIX;
}
