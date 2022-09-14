package com.wenwan.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public abstract class BaseQuery extends AuthBean {

    @ApiModelProperty("模糊搜索值")
    protected String search;

    protected int pageNo = 1;

    protected int pageSize = 10;

    protected String orderBy = "id";

    protected String orderType = "desc";

}
