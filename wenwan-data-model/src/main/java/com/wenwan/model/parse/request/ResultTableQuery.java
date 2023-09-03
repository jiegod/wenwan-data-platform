package com.wenwan.model.parse.request;

import com.wenwan.model.request.PageQuery;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ResultTableQuery extends PageQuery {
    @NotBlank(message = "businessLog is empty")
    private String businessLog;
    @NotNull(message = "businessLogId is null")
    private Long businessLogId;
}
