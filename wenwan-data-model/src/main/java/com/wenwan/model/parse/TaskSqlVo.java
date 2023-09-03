package com.wenwan.model.parse;

import com.wenwan.common.enums.SqlType;
import com.wenwan.model.request.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TaskSqlVo extends PageQuery {
    private Long id;
    @ApiModelProperty("SQL编号")
    private String code;
    @ApiModelProperty("任务组名称编号")
    private String taskGroupCode;
    @ApiModelProperty
    private Long taskGroupId;
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
    private Date operationTime;

    //param mapping
    @ApiModelProperty("sql关联的参数组")
    private List<TaskSqlParamVo> taskSqlParamVos;
}
