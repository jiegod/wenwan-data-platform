package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("parse_task")
public class ParseTaskMapping {
    @TableId(type= IdType.AUTO)
    private long id;
    @ApiModelProperty("解析规则id")
    private Long parseRuleId;
    @ApiModelProperty("任务组id")
    private Long taskGroupId;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationDate;//数据库设置为date类型

    private Date createTime;
    private Date updateTime;
}
