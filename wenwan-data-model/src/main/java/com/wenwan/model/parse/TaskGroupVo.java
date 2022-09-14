package com.wenwan.model.parse;

import com.wenwan.model.request.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TaskGroupVo extends PageQuery {
    private Long id;
    @ApiModelProperty("关联解析规则id")
    private Long parseRuleId;
    @ApiModelProperty("关联解析规则code")
    private String parseRuleCode;
    @ApiModelProperty("任务组编号")
    private String code;
    @ApiModelProperty("任务组名称")
    private String name;
    @ApiModelProperty("任务组描述")
    private String desc;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationTime;
}
