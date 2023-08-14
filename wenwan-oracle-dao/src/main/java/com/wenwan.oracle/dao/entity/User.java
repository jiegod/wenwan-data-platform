package com.wenwan.oracle.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {
    private Long id;
    private String username;
    private String password;
}