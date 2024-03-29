package com.wenwan.mysql.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("source_file")
//数据源：邮箱
public class SourceFile extends BaseModel {
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
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("分拣状态：0待分拣 1：已分拣")
    private Integer status;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Integer operationDate;
}
