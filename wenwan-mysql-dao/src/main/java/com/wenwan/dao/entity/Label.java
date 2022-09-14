package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

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
    private Date operationDate;//数据库设置为date类型

    private Date createTime;
    private Date updateTime;
}
