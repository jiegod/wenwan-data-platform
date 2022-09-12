package com.wenwan.model.parse;

import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ParseRuleVo extends BaseQuery {
    private long id;
    @ApiModelProperty("解析规则编码")
    private String code;
    @ApiModelProperty("规则名称")
    private String name;
    @ApiModelProperty("数据源")
    private String dataSource;
    @ApiModelProperty("优先级")
    private String priority;//优先级指的是同一个文件类型，范围广的优先级低
    @ApiModelProperty("文件类型")
    private String fileType;//1对1
    @ApiModelProperty("业务表")
    private String businessLog;
    @ApiModelProperty("描述")
    private String description;
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
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationDate;//数据库设置为date类型

    //table mapping
    @ApiModelProperty("解析规则关联的表")
    private List<ParseTableMappingVo> parseTableMappingVos;
}
