package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("task_group")
public class TaskGroup {
    @TableId(type= IdType.AUTO)
    private Long id;
    @ApiModelProperty("任务组编号")
    private String code;
    @ApiModelProperty("任务组名称")
    private String name;
    @ApiModelProperty("任务组描述")
    private String desc;
    @ApiModelProperty("台账编号")
    //todo 解析模版跟任务组关系，一对多？
    private String parseRuleCode;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationTime;

    private Date createTime;
    private Date updateTime;
}
