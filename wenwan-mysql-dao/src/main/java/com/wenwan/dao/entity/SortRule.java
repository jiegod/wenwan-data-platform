package com.wenwan.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class SortRule {
    private long id;
    private long labelId;//todo 五要素对标签 1对多
    @ApiModelProperty("分拣规则名称")
    private String name;
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
    //todo 加个优先级
    private String description;
    private String creator;
    private String modifier;
    private Date createTime;
    private Date updateTime;
}
