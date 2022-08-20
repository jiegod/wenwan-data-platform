package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("column_info")
public class ColumnInfo {
    @TableId(type= IdType.AUTO)
    private Long id;
    private Long tableId;
    private String name;
    private String comment;
    private String type;
    private String length;
    private String operator;
    private String operationTime;

    private Date createDate;
    private Date updateDate;
}
