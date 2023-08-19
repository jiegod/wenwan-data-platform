package com.wenwan.model.parse.request;

import com.wenwan.model.request.PageQuery;
import lombok.Data;

@Data
public class TargetTableQuery extends PageQuery {

    private Integer parseRuleId;
    private String order;
}
