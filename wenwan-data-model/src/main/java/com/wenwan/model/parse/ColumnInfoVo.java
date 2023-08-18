package com.wenwan.model.parse;

import com.wenwan.common.exception.BusinessException;
import com.wenwan.model.request.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class ColumnInfoVo extends PageQuery {
    private Long id;
    @ApiModelProperty("所属表id")
    @NotNull(message = "tableId not be null")
    private Long tableId;
    @NotNull(message = "column name not be null")
    @ApiModelProperty("列名")
    private String name;
    @ApiModelProperty("列中文名")
    private String comment;
    @NotNull(message = "column type not be null")
    @ApiModelProperty("列类型")
    private String type;
    @ApiModelProperty("列长度")
    private String length;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date operationTime;

    public static void paramCheck(List<ColumnInfoVo> columnInfoVos) {
        Map<String, Long> orderCount = columnInfoVos.stream().collect(Collectors.groupingBy(ColumnInfoVo::getName, Collectors.counting()));
        if(orderCount.values().stream().allMatch(count -> count>1)) {
            throw new BusinessException("Column name can not duplicate");
        }
    }

    public static List<ColumnInfoVo> defaultColumn(Long tableId, String operator) {
        ColumnInfoVo fileId = new ColumnInfoVo();
        fileId.setTableId(tableId);
        fileId.setName("file_id");
        fileId.setComment("fileId");
        fileId.setType("Varchar");
        fileId.setLength("32");
        fileId.setOperator(operator);

        ColumnInfoVo rowId = new ColumnInfoVo();
        rowId.setTableId(tableId);
        rowId.setName("row_id");
        rowId.setComment("rowId");
        rowId.setType("Varchar");
        rowId.setLength("32");
        rowId.setOperator(operator);

        List<ColumnInfoVo> result = new ArrayList<>();
        result.add(fileId);
        result.add(rowId);
        return result;
    }
}
