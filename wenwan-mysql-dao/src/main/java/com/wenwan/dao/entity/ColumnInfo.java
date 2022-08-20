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
    //关联表id
    private Long tableId;
    //列名
    private String name;
    //列中文名
    private String comment;
    //列类型
    private String type;
    //列长度
    private String length;
    //操作人
    private String operator;
    //操作时间
    private Date operationTime;

    private Date createDate;
    private Date updateDate;
}
