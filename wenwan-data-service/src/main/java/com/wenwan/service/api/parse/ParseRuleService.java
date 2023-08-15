package com.wenwan.service.api.parse;

import com.wenwan.common.api.SearchResult;
import com.wenwan.model.enums.Datasource;
import com.wenwan.model.parse.BusinessLogVo;
import com.wenwan.model.parse.FileTypeVo;
import com.wenwan.model.parse.ParseRuleVo;
import com.wenwan.model.parse.request.BusinessLogQuery;
import com.wenwan.mysql.dao.entity.ParseRule;

import java.util.List;

;

public interface ParseRuleService {

    Integer insert(ParseRuleVo parseRule);
    Integer delete(Long id);
    Integer update(ParseRuleVo parseRule);
    SearchResult<ParseRuleVo> list(ParseRuleVo parseRule);
    List<FileTypeVo> fileTypeList(FileTypeVo fileTypeVo);
    List<ParseRule> all4Parse(Datasource datasource);
    SearchResult<BusinessLogVo> businessLog(BusinessLogQuery businessLogQuery);
}
