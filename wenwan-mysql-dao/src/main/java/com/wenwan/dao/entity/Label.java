package com.wenwan.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Label {
    private long id;
    private String label;
    //todo 标签会跟数据源做分类吗
    private String dataSource;
    private String creator;
    private String modifier;
    private Date createTime;
    private Date modifyTime;
}
