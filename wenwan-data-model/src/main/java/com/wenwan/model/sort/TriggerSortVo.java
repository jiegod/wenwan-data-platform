package com.wenwan.model.sort;

import com.wenwan.model.request.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class TriggerSortVo extends PageQuery {

    @ApiModelProperty("目标分类 ex:aa,bb,cc")
    @NotEmpty
    private String labels;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("智能学习")
    private SortRuleVo sortRuleVo;
    @ApiModelProperty("文件id")
    @NotBlank
    private Long fileId;
}
