package com.wenwan.model.parse;

import com.wenwan.model.request.BaseQuery;
import lombok.Data;

@Data
public class ColumnInfoVo extends BaseQuery {
    private Long id;
    private String dbName;
    private String tableName;
    private String comment;
    private String operator;
    private String operationTime;
}
