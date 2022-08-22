package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wenwan.common.enums.SqlType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("task_sql")
public class TaskSql {
    @TableId(type= IdType.AUTO)
    private Long id;
    @ApiModelProperty("SQL编号")
    private String code;
    @ApiModelProperty("任务组id")
    private Long taskGroupId;
    @ApiModelProperty("任务组编号")
    private String taskGroupCode;
    @ApiModelProperty("SQL类型")
    private SqlType type;
    @ApiModelProperty("启用状态")
    private String status;
    @ApiModelProperty("执行顺序")
    private String priority;
    @ApiModelProperty("SQL语句")
    private String content;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationDate;//数据库设置为date类型

    private Date createTime;
    private Date updateTime;
}
