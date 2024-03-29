package com.wenwan.model.parse;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BusinessLogVo {

    @ApiModelProperty("台账id")
    private Long parseRuleId;
    @ApiModelProperty("台账code")
    private String parseRuleCode;
    @ApiModelProperty("file_id")
    private Long fileId;
    @ApiModelProperty("接收方")
    private String receiver;
    @ApiModelProperty("发送方")
    private String sender;
    @ApiModelProperty("邮件主题")
    private String theme;
    @ApiModelProperty("接受日期")
    private String receiveDate;
    @ApiModelProperty("邮件正文")
    private String content;
    @ApiModelProperty("附件名")
    private String fileName;
    @ApiModelProperty("附件路径")
    private String filePath;
    @ApiModelProperty("文件类型")
    private String fileType;
    @ApiModelProperty("数据源")
    private String dataSource;
    @ApiModelProperty("加载状态;1-加载成功 2-加载失败")
    private Integer loadingStatus;
    @ApiModelProperty("落地状态;0-未开始 1-落地成功 2-落地失败")
    private Integer tableStatus;
    @ApiModelProperty("解析状态;0-未开始 1-解析成功 2-解析失败 3-稽核成功")
    private Integer parseStatus;
    @ApiModelProperty("操作时间")
    private Date operationDate;//数据库设置为date类型
}
