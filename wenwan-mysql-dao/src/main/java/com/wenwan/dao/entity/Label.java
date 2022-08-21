package com.wenwan.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Label {
    private long id;
    private String label;
    private String creator;
    private String modifier;
    private Date createTime;
    private Date modifyTime;
}
