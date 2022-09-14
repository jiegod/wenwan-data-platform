package com.wenwan.model.parse;

import com.wenwan.model.request.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ColumnInfoVo extends PageQuery {
    private Long id;
    @ApiModelProperty("所属表id")
    @NotNull(message = "tableId not be null")
    private Long tableId;
    @NotNull(message = "column name not be null")
    @ApiModelProperty("列名")
    private String name;
    @ApiModelProperty("列中文名")
    private String comment;
    @NotNull(message = "column type not be null")
    @ApiModelProperty("列类型")
    private String type;
    @ApiModelProperty("列长度")
    private String length;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationTime;
}
