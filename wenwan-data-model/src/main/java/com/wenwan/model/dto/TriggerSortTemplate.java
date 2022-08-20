package com.wenwan.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TriggerSortTemplate {
    //todo 五要素正则是用户手动输入的还是通过选中的文件生成的
    @ApiModelProperty("收件箱正则")
    private String receiver;
    @ApiModelProperty("发件人正则")
    private String sender;
    @ApiModelProperty("主题正则")
    private String theme;
    @ApiModelProperty("文件名正则")
    private String fileName;
    @ApiModelProperty("有效期开始")
    private Date validStart;
    @ApiModelProperty("有效期结束")
    private Date validEnd;
}
