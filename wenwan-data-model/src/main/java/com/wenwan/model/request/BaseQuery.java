package com.wenwan.model.request;

import lombok.Data;

@Data
public abstract class BaseQuery extends AuthBean {

    protected int pageNo = 1;

    protected int pageSize = 10;

    protected String orderBy = "id";

    protected String orderType = "desc";

}
