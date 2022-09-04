package com.wenwan.model.sort;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class SourceFileVo extends BaseQuery {
    private long id;
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
    @ApiModelProperty("目标分类")
    private String labels;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationDate;//数据库设置为date类型

}