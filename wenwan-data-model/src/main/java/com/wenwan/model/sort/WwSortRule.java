package com.wenwan.model.sort;

import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class WwSortRule extends BaseQuery {
    private long id;
    @ApiModelProperty("分拣规则编码")
    private String code;
    @ApiModelProperty("规则名称")
    private String name;
    @ApiModelProperty("分类")
    private String label;
    @ApiModelProperty("有效期")
    private Date validStart;
    @ApiModelProperty("有效期")
    private Date validEnd;
    @ApiModelProperty("备注")
    private String description;
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
    private String creator;
    private String modifier;
}
