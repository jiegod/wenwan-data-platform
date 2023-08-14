package com.wenwan.service.api.parse;

import com.wenwan.common.api.SearchResult;
import com.wenwan.mysql.dao.entity.ParseRule;
import com.wenwan.model.enums.Datasource;
import com.wenwan.model.parse.BusinessLogVo;
import com.wenwan.model.parse.FileTypeVo;
import com.wenwan.model.parse.FilterKey;
import com.wenwan.model.parse.ParseRuleVo;
import com.wenwan.model.parse.request.BusinessLogQuery;
import com.wenwan.model.request.PageQuery;

import java.util.List;
import java.util.Map;
import java.util.Set;

;

public interface ParseRuleService {

    Integer insert(ParseRuleVo parseRule);
    Integer delete(Long id);
    Integer update(ParseRuleVo parseRule);
    SearchResult<ParseRuleVo> list(ParseRuleVo parseRule);
    List<FileTypeVo> fileTypeList(FileTypeVo fileTypeVo);
    List<ParseRule> all4Parse(Datasource datasource);

    Map<String, Set<String>> dropList(FilterKey filterKey);

    SearchResult<BusinessLogVo> businessLog(BusinessLogQuery businessLogQuery);
}
