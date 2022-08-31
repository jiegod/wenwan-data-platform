package com.wenwan.model.sort;

import com.wenwan.model.request.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TriggerSortVo extends BaseQuery {

    @ApiModelProperty("目标分类")
    private String labels;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("智能学习")
    private SortRuleVo sortRuleVo;
}
