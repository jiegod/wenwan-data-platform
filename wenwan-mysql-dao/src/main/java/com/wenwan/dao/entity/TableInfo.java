package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("table_info")
public class TableInfo extends BaseModel {
    @ApiModelProperty("库名")
    private String dbName;
    @ApiModelProperty("表名")
    private String tableName;
    @ApiModelProperty("表中文名")
    private String comment;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationDate;//数据库设置为date类型

    private Date createTime;
    private Date updateTime;
}
