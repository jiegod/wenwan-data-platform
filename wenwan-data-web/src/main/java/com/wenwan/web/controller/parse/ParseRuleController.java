package com.wenwan.web.controller.parse;

import com.wenwan.api.parse.IParseRuleApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.FileTypeVo;
import com.wenwan.model.parse.ParseRuleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ParseRuleController implements IParseRuleApi {

    @Override
    public APIResponse<Void> insert(ParseRuleVo parseRule) {
        return null;
    }

    @Override
    public APIResponse<Void> delete(Long id) {
        return null;
    }

    @Override
    public APIResponse<Void> update(ParseRuleVo parseRule) {
        return null;
    }

    @Override
    public APIResponse<SearchResult<ParseRuleVo>> list(ParseRuleVo parseRule) {
        return null;
    }

    @Override
    public APIResponse<List<FileTypeVo>> fileTypeList(FileTypeVo fileTypeVo) {
        return null;
    }
}
