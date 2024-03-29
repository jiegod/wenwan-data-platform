package com.wenwan.mysql.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("label")
public class Label extends BaseModel{
    @ApiModelProperty("标签名")
    private String name;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("收件箱")
    private String receiver;
    @ApiModelProperty("操作时间")
    private Integer operationDate;
}
