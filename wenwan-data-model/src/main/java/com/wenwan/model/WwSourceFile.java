package com.wenwan.model;

import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

@Data
public class WwSourceFile extends BaseQuery {
    private long id;
    @ApiModelProperty("接收方")
    private String receiver;
    @ApiModelProperty("发送方")
    private String sender;
    @ApiModelProperty("内容主题")
    private String theme;
    @ApiModelProperty("接受日期")
    private String receiveDate;
    @ApiModelProperty("文件名")
    private String attachment;
    @ApiModelProperty("多标签拼接")
    private String classifications;

    private Date createTime;
    private Date modifyTime;
}
