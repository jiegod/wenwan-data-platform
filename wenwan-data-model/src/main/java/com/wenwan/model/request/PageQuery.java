package com.wenwan.model.request;

import lombok.Data;

@Data
public abstract class PageQuery extends ListQuery {

    protected int pageNo = 1;

    protected int pageSize = 10;

}
