package com.wenwan.model.parse;

import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TableInfoVo extends BaseQuery {
    private Long id;
    @ApiModelProperty("库名")
    private String dbName;
    @ApiModelProperty("表名")
    private String tableName;
    @ApiModelProperty("表中文名")
    private String comment;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private String operationTime;
}
