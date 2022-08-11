package com.wenwan.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public abstract class AuthBean {

    @ApiModelProperty("登录人")
    protected String loginUser;
}
