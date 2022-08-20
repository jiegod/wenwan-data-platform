package com.wenwan.model.parse;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TaskSqlVo {
    private Long id;
    @ApiModelProperty("SQL编号")
    private String code;
    @ApiModelProperty("任务组名称编号")
    private String taskGroupCode;
    @ApiModelProperty("SQL类型")
    private String type;
    @ApiModelProperty("启用状态")
    private String status;
    @ApiModelProperty("执行顺序")
    private String priority;
    @ApiModelProperty("SQL语句")
    private String content;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationTime;
}
