package com.wenwan.common.constant;

public enum MysqlValueType {
    CHAR(1),
    VARCHAR(1),
    TINYBLOB(1),
    TINYTEXT(1),
    BLOB(1),
    TEXT(1),
    MEDIUMBLOB(1),
    MEDIUMTEXT(1),
    LONGBLOB(1),
    LONGTEXT(1),
    DATE(1),
    TIME(1),
    YEAR(1),
    DATETIME(1),
    TIMESTAMP(1),
    TINYINT(2),
    SMALLINT(2),
    MEDIUMINT(2),
    INT(2),
    INTEGER(2),
    BIGINT(2),
    FLOAT(2),
    DOUBLE(2),
    DECIMAL(2),
    ;

    /**
     * 1-代表字符
     * 2-代表数值
     */
    private int type;

    MysqlValueType(int type) {
        this.type = type;
    }

    public static MysqlValueType get(String mysqlValueType){
        for (MysqlValueType value : MysqlValueType.values()) {
            if(value.name().equals(mysqlValueType)){
                return value;
            }
        }
        return null;
    }

    public int getType() {
        return type;
    }
}
