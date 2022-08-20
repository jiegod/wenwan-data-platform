package com.wenwan.model.request.sort;

import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SourceFileRequest extends BaseQuery {

    private String classifications;
    private String status;
    private String receiveDateStart;
    private String receiveDateEnd;
    private String receiver;
    @ApiModelProperty("内容主题")
    private String theme;
    @ApiModelProperty("附件名")
    private String attachment;
    private String monitorName;
}
