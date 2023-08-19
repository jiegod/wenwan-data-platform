package com.wenwan.model.parse.result;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TargetTableResult {
    private List<String> header;
    private List<Map<String, String>> rows;
    private Integer size;
    private Integer pageNo;
    private Integer pageSize;
}
