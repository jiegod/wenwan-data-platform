package com.wenwan.model.parse;

import com.wenwan.model.request.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class TableInfoVo extends PageQuery {
    private Long id;
    @ApiModelProperty("库名")
    @NotBlank(message = "db name is null")
    private String dbName;
    @NotBlank(message = "table name is null")
    @ApiModelProperty("表名")
    private String tableName;
    @ApiModelProperty("表中文名")
    private String comment;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationTime;
}
