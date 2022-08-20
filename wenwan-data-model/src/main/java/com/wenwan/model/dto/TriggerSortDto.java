package com.wenwan.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class TriggerSortDto {

    private List<String> fileIds;
    @ApiModelProperty("分类标签")
    private String classification;
    @ApiModelProperty("描述")
    private String description;
    private TriggerSortTemplate triggerSortTemplate;
}
