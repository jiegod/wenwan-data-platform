package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("column_info")
public class ColumnInfo {
    @TableId(type= IdType.AUTO)
    private Long id;
    @ApiModelProperty("关联表id")
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

    private Date createTime;
    private Date updateTime;
}
