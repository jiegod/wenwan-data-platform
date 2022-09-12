package com.wenwan.model.parse;

import com.wenwan.common.enums.SqlType;
import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TaskSqlVo extends BaseQuery {
    private Long id;
    @ApiModelProperty("SQL编号")
    private String code;
    @ApiModelProperty("任务组名称编号")
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
    private Date operationTime;

    //param mapping
    @ApiModelProperty("sql关联的参数组")
    private List<List<TaskSqlParamVo>> taskSqlParamVos;
}
