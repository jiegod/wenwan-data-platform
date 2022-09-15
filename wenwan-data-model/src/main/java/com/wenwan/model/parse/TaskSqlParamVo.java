package com.wenwan.model.parse;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
//N组参数，执行N次
public class TaskSqlParamVo {
    private Long id;
    @ApiModelProperty("关联sql-id")
    private Long taskSqlId;
    @ApiModelProperty("关联sql-code")
    private String taskSqlCode;
    @ApiModelProperty("参数组")
    private Integer group;
    @ApiModelProperty("参数名")
    private String key;
    @ApiModelProperty("参数值")
    private String value;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Integer operationDate;//数据库设置为date类型

    private Date createTime;
    private Date updateTime;
}
