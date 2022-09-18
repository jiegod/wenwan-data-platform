package com.wenwan.service.api.parse;

import com.wenwan.common.api.SearchResult;
import com.wenwan.dao.entity.ParseRule;
import com.wenwan.model.enums.Datasource;
import com.wenwan.model.parse.FileTypeVo;
import com.wenwan.model.parse.ParseRuleVo;

import java.util.List;

;

public interface ParseRuleService {

    Integer insert(ParseRuleVo parseRule);
    Integer delete(Long id);
    Integer update(ParseRuleVo parseRule);
    SearchResult<ParseRuleVo> list(ParseRuleVo parseRule);
    List<FileTypeVo> fileTypeList(FileTypeVo fileTypeVo);
    List<ParseRule> all4Parse(Datasource datasource);
}
