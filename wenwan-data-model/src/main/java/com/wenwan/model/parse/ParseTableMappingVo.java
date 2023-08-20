package com.wenwan.model.parse;


import com.wenwan.common.exception.BusinessException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class ParseTableMappingVo {
    private long id;
    @ApiModelProperty("解析规则id")
    private Long parseRuleId;
    @ApiModelProperty("表id")
    private Long tableId;
    @ApiModelProperty("顺序")
    @NotBlank(message = "sheet number can not be empty")
    private String order;//依次为sheet1、sheet2....
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Integer operationDate;//数据库设置为date类型

    public static void paramCheck(List<ParseTableMappingVo> parseTables) {
        if (CollectionUtils.isEmpty(parseTables)) {
            throw new BusinessException("parse table list is empty");
        }
        parseTables.forEach(parseTableMappingVo -> {
            if (parseTableMappingVo.getTableId() == null) {
                throw new BusinessException("Table can not be null");
            }
            if (parseTableMappingVo.getParseRuleId() == null) {
                throw new BusinessException("Rule id can not be null");
            }
            if (parseTableMappingVo.getOrder() == null) {
                throw new BusinessException("Sheet number can not be null");
            }
        });
        Map<String, Long> orderCount = parseTables.stream().collect(Collectors.groupingBy(ParseTableMappingVo::getOrder, Collectors.counting()));
        if (orderCount.values().stream().allMatch(count -> count > 1)) {
            throw new BusinessException("Sheet Number can not duplicate");
        }
    }
}
