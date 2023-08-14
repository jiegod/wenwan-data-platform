package com.wenwan.mysql.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wenwan.common.enums.SqlType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("sql_log")
public class SqlLog extends BaseModel {
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
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Integer operationDate;

}
