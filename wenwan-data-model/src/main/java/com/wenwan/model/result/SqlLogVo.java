package com.wenwan.model.result;

import com.wenwan.common.enums.SqlType;
import com.wenwan.model.request.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SqlLogVo extends PageQuery {
    private Long id;
    @ApiModelProperty("关联解析规则id")
    private Long parseRuleId;
    @ApiModelProperty("关联解析规则code")
    private String parseRuleCode;
    @ApiModelProperty("FILE_ID")
    private Long fileId;
    @ApiModelProperty("任务组id")
    private Long taskGroupId;
    @ApiModelProperty("任务组code")
    private String taskGroupCode;
    @ApiModelProperty("sql-id")
    private Long taskSqlId;
    @ApiModelProperty("sql-code")
    private String taskSqlCode;
    @ApiModelProperty("SQL类型")
    private SqlType type;
    @ApiModelProperty("执行顺序")
    private String priority;
    @ApiModelProperty("执行状态 0-成功 1-失败")
    private Integer status;
    @ApiModelProperty("异常信息")
    private String error;
    @ApiModelProperty("执行时长")
    private Long costTime;

}
