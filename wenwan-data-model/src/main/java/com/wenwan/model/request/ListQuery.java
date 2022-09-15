package com.wenwan.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public abstract class ListQuery {

    @ApiModelProperty("模糊搜索值")
    protected String search;

}
