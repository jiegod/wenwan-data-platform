package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class User extends BaseModel{

    private String username;
    private String password;
}
