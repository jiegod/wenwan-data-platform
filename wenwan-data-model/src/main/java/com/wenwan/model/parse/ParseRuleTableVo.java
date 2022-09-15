package com.wenwan.model.parse;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ParseRuleTableVo {
    private Long parseRuleId;
    private Long tableId;
    @ApiModelProperty("库名")
    private String dbName;
    @ApiModelProperty("表名")
    private String tableName;
    @ApiModelProperty("表中文名")
    private String comment;
    @ApiModelProperty
    private String order;
}
