package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseModel {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Date createTime;
    private Date updateTime;
}
