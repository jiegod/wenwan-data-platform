package com.wenwan.model.parse;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TaskGroupVo {
    private Long id;
    @ApiModelProperty("任务组编号")
    private String code;
    @ApiModelProperty("任务组名称")
    private String name;
    @ApiModelProperty("任务组描述")
    private String desc;
    //todo 一个任务组关联多个解析模版，有可能吗？
    @ApiModelProperty("台账编号")
    private String parseRuleCode;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationTime;
}
