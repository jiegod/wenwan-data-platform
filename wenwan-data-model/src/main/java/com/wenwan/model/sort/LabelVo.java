package com.wenwan.model.sort;

import com.wenwan.model.request.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class LabelVo extends PageQuery {
    private long id;
    @ApiModelProperty("标签名")
    private String name;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("收件箱")
    private String receiver;
    @ApiModelProperty("操作时间")
    private Integer operationDate;//数据库设置为date类型
}
