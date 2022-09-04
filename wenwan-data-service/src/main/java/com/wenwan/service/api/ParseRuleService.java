package com.wenwan.service.api;

import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.FileTypeVo;
import com.wenwan.model.parse.ParseRuleVo;

import java.util.List;

;

public interface ParseRuleService {

    APIResponse<Void> insert(ParseRuleVo parseRule);

    APIResponse<Void> delete(Long id);

    APIResponse<Void> update(ParseRuleVo parseRule);


    APIResponse<SearchResult<ParseRuleVo>> list(ParseRuleVo parseRule);

    APIResponse<List<FileTypeVo>> fileTypeList(FileTypeVo fileTypeVo);
}
