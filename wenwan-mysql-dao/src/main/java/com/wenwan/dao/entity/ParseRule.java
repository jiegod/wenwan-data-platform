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
    //优先级指的是同一个分类，范围广的优先级低
    private String priority;
    @ApiModelProperty("分类标签")
    private String label;//1对1
    @ApiModelProperty("business_log")
    private String businessLog;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("业务落地表")
    private String tableIds;//todo 1对多
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
