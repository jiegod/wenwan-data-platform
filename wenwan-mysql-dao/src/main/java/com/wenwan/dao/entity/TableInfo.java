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
    private String dbName;
    private String tableName;
    private String comment;
    private String operator;
    private String operationTime;

    private Date createDate;
    private Date updateDate;
}
