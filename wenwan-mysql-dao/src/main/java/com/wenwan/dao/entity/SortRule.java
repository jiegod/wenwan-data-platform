package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sort_rule")
public class SortRule {
    @TableId(type= IdType.AUTO)
    private long id;
    @ApiModelProperty("标签")
    private String labels;//五要素对标签 1对多
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
    @ApiModelProperty("优先级")
    private String priority;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationDate;//数据库设置为date类型

    private Date createTime;
    private Date updateTime;
}
