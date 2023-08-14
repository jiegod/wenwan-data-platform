package com.wenwan.mysql.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wenwan.common.enums.SqlType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("task_sql")
public class TaskSql extends BaseModel {
    @ApiModelProperty("SQL编号")
    private String code;
    @ApiModelProperty("任务组id")
    private Long taskGroupId;
    @ApiModelProperty("任务组编号")
    private String taskGroupCode;
    @ApiModelProperty("SQL类型")
    private SqlType type;
    @ApiModelProperty("状态,0-启动，1-禁用")
    private Integer status;
    @ApiModelProperty("执行顺序")
    private String priority;
    @ApiModelProperty("SQL语句")
    private String content;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Integer operationDate;
}
