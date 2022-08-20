package com.wenwan.model.parse;

import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TableInfoVo extends BaseQuery {
    private Long id;
    @ApiModelProperty("库名")
    private String dbName;
    private String tableName;
    private String comment;
    private String operator;
    private String operationTime;
}
