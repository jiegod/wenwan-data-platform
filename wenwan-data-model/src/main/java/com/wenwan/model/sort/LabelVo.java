package com.wenwan.model.sort;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class LabelVo extends BaseQuery {
    private long id;
    @ApiModelProperty("标签名")
    private String name;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("收件箱")
    private String receiver;
    @ApiModelProperty("操作时间")
    private Date operationDate;//数据库设置为date类型
}
