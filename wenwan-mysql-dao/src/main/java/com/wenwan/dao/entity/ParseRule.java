package com.wenwan.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ParseRule {
    private long id;
    @ApiModelProperty("解析规则编码")
    private String code;
    @ApiModelProperty("规则名称")
    private String name;
    @ApiModelProperty("优先级")
    //todo 多个规则匹配同一个标签的时候使用优先级
    private String priority;
    @ApiModelProperty("分类标签")
    //todo 一个规则有多个标签吗？
    private long labelId;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("业务落地表")
    //todo 这个是target table还是落地表
    private String busLogTable;
    @ApiModelProperty("五要素一 文件路径正则")
    private String filePath;
    @ApiModelProperty("五要素二 文件名称正则")
    private String fileName;
    @ApiModelProperty("五要素三 发送方正则")
    private String sender;
    @ApiModelProperty("五要素四 接收方正则")
    private String receiver;
    @ApiModelProperty("五要素五 文件主题正则")
    private String theme;
    @ApiModelProperty("数据源")
    private String dataSource;
    private String status;
    @ApiModelProperty("操作时间")
    private Date operateTime;
    private String creator;
    private String modifier;
    private Date createTime;
    private Date updateTime;
}
