package com.wenwan.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
public class SourceFile {

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
    private String attachmentName;
    private String attachmentPath;
    private String creator;
    private String modifier;
    private Date createTime;
    private Date updateTime;
}
