package com.wenwan.model.parse;

import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.Date;

@Data
public class ColumnInfoVo extends BaseQuery {
    private Long id;
    private String name;
    private String comment;
    private String type;
    private String length;
    private String operator;
    private String operationTime;
}
