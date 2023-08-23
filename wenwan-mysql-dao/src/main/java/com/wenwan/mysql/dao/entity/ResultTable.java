package com.wenwan.mysql.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResultTable extends BaseModel{
    @ApiModelProperty("file_id")
    private Long fileId;
    @ApiModelProperty("content")
    private String content;
}
