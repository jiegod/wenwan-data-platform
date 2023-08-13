package com.wenwan.model.parse.request;

import com.wenwan.model.request.PageQuery;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BusinessLogQuery extends PageQuery {
    @NotNull(message = "rule is can not be null")
    private Long parseRuleId;
}
