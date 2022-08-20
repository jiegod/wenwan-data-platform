package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("table_info")
public class TableInfo {
    @TableId(type= IdType.AUTO)
    private Long id;
    //库名
    private String dbName;
    //表名
    private String tableName;
    //表中文名
    private String comment;
    //操作人
    private String operator;
    //操作时间
    private Date operationTime;

    private Date createDate;
    private Date updateDate;
}
