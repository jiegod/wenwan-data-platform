package com.wenwan.mysql.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("task_sql_param")
//N组参数，执行N次
public class TaskSqlParam extends BaseModel {
    @ApiModelProperty("关联sql-id")
    private Long taskSqlId;
    @ApiModelProperty("关联sql-code")
    private String taskSqlCode;
    @ApiModelProperty("参数组")
    @TableField("`group`")
    private Integer group;
    @ApiModelProperty("参数名")
    @TableField("`key`")
    private String key;
    @TableField("`value`")
    @ApiModelProperty("参数值")
    private String value;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Integer operationDate;
}
