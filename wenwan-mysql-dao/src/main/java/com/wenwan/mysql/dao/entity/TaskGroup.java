package com.wenwan.mysql.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("task_group")
public class TaskGroup extends BaseModel {
    @ApiModelProperty("关联解析规则id")
    private Long parseRuleId;
    @ApiModelProperty("关联解析规则code")
    private String parseRuleCode;
    @ApiModelProperty("任务组编号")
    private String code;
    @ApiModelProperty("任务组名称")
    private String name;
    @ApiModelProperty("任务组描述")
    @TableField("`desc`")
    private String desc;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Integer operationDate;
}
