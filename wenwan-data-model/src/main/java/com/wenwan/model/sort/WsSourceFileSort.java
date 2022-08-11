package com.wenwan.model.sort;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WsSourceFileSort {
    private long id;
    @ApiModelProperty("文件id")
    private String fileId;
    @ApiModelProperty("分类")
    private String classification;

    //按照ppt调整request

}
