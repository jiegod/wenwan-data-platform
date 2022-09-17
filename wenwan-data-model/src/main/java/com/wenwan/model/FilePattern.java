package com.wenwan.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
public class FilePattern {
    @ApiModelProperty("五要素一 文件路径正则")
    private String filePathRegular;
    @ApiModelProperty("五要素二 文件名称正则")
    private String fileNameRegular;
    @ApiModelProperty("五要素三 发送方正则")
    private String senderRegular;
    @ApiModelProperty("五要素四 接收方正则")
    private String receiverRegular;
    @ApiModelProperty("五要素五 文件主题正则")
    private String themeRegular;
    private List<String> labels;
}
