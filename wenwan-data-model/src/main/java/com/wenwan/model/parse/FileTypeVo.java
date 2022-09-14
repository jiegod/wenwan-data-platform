package com.wenwan.model.parse;

import com.wenwan.model.request.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class FileTypeVo extends PageQuery {
    private long id;
    @ApiModelProperty("文件类型")
    private String name;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationDate;//数据库设置为date类型

    private Date createTime;
    private Date updateTime;
}
