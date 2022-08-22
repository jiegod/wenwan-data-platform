package com.wenwan.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

@Data
public class SourceFileDto {
    private long id;
    @ApiModelProperty("接收方")
    private String receiver;
    @ApiModelProperty("发送方")
    private String sender;
    @ApiModelProperty("邮件主题")
    private String theme;
    @ApiModelProperty("接受日期")
    private String receiveDate;
    @ApiModelProperty("附件名")
    private String attachment;
    @ApiModelProperty("多标签拼接分类")
    private String labels;
    @ApiModelProperty("处理状态")
    private String status;
    @ApiModelProperty("监控状态")
    private String monitorStatus;

    private Date createTime;
    private Date modifyTime;
}
