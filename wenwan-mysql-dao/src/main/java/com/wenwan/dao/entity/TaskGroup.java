package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("task_group")
public class TaskGroup {
    @TableId(type= IdType.AUTO)
    private Long id;
    //任务组编号
    private String code;
    //任务组名称
    private String name;
    //任务组描述
    private String desc;
    //台账编号
    private String parseRuleCode;
    //操作人
    private String operator;
    //操作时间
    private Date operationTime;

    private Date createDate;
    private Date updateDate;
}
