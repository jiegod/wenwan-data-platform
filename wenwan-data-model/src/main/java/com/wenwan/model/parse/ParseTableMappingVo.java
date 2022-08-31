package com.wenwan.model.parse;


import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ParseTableMappingVo extends BaseQuery {
    private long id;
    @ApiModelProperty("解析规则id")
    private Long parseRuleId;
    @ApiModelProperty("表id")
    private Long tableId;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("顺序")
    private String order;//依次为sheet1、sheet2....
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationDate;//数据库设置为date类型

    private Date createTime;
    private Date updateTime;
}
