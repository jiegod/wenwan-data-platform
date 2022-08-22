package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("task_sql_param")
//N组参数，执行N次
public class TaskSqlParam {
    @TableId(type= IdType.AUTO)
    private Long id;
    @ApiModelProperty("关联sql-id")
    private String taskSqlId;
    @ApiModelProperty("参数组")
    private Integer group;
    @ApiModelProperty("参数名")
    private String key;
    @ApiModelProperty("参数值")
    private String value;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationDate;//数据库设置为date类型

    private Date createTime;
    private Date updateTime;
}
