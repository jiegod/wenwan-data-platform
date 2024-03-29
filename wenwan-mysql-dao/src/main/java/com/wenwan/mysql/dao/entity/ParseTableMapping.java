package com.wenwan.mysql.dao.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("parse_table_mapping")
public class ParseTableMapping extends BaseModel {
    @ApiModelProperty("解析规则id")
    private Long parseRuleId;
    @ApiModelProperty("表id")
    private Long tableId;
    @ApiModelProperty("顺序")
    @TableField("`order`")
    private String order;//依次为sheet1、sheet2....
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Integer operationDate;
}
