package com.wenwan.mysql.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sort_rule")
public class SortRule extends BaseModel {
    @ApiModelProperty("目标分类")
    private String labels;//五要素对标签 1对多,逗号分隔
    @ApiModelProperty("分拣规则名称")
    private String name;
    @ApiModelProperty("收件箱正则")
    private String receiverRegular;
    @ApiModelProperty("发件人正则")
    private String senderRegular;
    @ApiModelProperty("主题正则")
    private String themeRegular;
    @ApiModelProperty("文件名正则")
    private String fileNameRegular;
    @ApiModelProperty("优先级")
    private String priority;
    @ApiModelProperty("有效期开始")
    private Date expireStart;
    @ApiModelProperty("有效期结束")
    private Date expireEnd;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Integer operationDate;
}
