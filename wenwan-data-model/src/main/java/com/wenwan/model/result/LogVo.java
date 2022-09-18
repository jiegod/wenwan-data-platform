package com.wenwan.model.result;

import com.wenwan.model.request.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class LogVo extends PageQuery {
    private long id;
    @ApiModelProperty("台账id")
    private Long parseRuleId;
    @ApiModelProperty("台账code")
    private String parseRuleCode;
    @ApiModelProperty("FILE_ID")
    private Long fileId;
    @ApiModelProperty("FILE_ID")
    private Long businessLogId;
    @ApiModelProperty("bus_log表名")
    private String businessLogName;
    @ApiModelProperty("附件名")
    private String fileName;
    @ApiModelProperty("附件路径")
    private String filePath;
    @ApiModelProperty("解析状态")
    private String parseStatus;
    @ApiModelProperty("加载状态;0-加载成功 1-加载失败")
    private Integer loadingStatus;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Integer operationDate;//数据库设置为date类型


    @ApiModelProperty("查询开始时间")
    private Date queryDateStart;
    @ApiModelProperty("查询结束时间")
    private Date queryDateEnd;
}
