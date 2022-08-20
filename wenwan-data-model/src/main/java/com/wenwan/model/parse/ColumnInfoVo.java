package com.wenwan.model.parse;

import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.Date;

@Data
public class ColumnInfoVo extends BaseQuery {
    private Long id;
    @ApiModelProperty("所属表id")
    private Long tableId;
    @ApiModelProperty("列名")
    private String name;
    @ApiModelProperty("列中文名")
    private String comment;
    @ApiModelProperty("列类型")
    private String type;
    @ApiModelProperty("列长度")
    private String length;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationTime;
}
