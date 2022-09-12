package com.wenwan.service.constant;

public interface DDLConstant {
    String PLACEHOLDER_DB_NAME = "@@dbName@@";
    String PLACEHOLDER_TABLE_NAME = "@@tableName@@";
    String PLACEHOLDER_FIELD_LIST = "@@fieldList@@";
    String PLACEHOLDER_TABLE_COMMENT = "@@tableComment@@";

    String DDL_FIELD_TPL = "`%s` %s(%s) DEFAULT NULL COMMENT '%s'";
    String DDL_FIELD_PREFIX = "\t";
    String DDL_FIELD_SEPARATOR = ",\n" + DDL_FIELD_PREFIX;

    String DDL_CREATE_TABLE_TPL = "CREATE TABLE `@@dbName@@`.`@@tableName@@` (\n@@fieldList@@ \n)  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '@@tableComment@@'";
}
