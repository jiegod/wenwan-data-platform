package com.wenwan.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public abstract class ListQuery extends AuthBean {

    @ApiModelProperty("模糊搜索值")
    protected String search;

    protected String orderBy = "id";

    protected String orderType = "desc";

}
