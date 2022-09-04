package com.wenwan.web.controller.parse;

import com.wenwan.api.parse.IParseRuleApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.FileTypeVo;
import com.wenwan.model.parse.ParseRuleVo;
import com.wenwan.service.api.ParseRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ParseRuleController implements IParseRuleApi {

    @Autowired
    private ParseRuleService parseRuleService;

    @Override
    public APIResponse<Void> insert(ParseRuleVo parseRule) {
        parseRuleService.insert(parseRule);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<Void> delete(Long id) {
        parseRuleService.delete(id);
        return null;
    }

    @Override
    public APIResponse<Void> update(ParseRuleVo parseRule) {
        parseRuleService.update(parseRule);
        return null;
    }

    @Override
    public APIResponse<SearchResult<ParseRuleVo>> list(ParseRuleVo parseRule) {
        return parseRuleService.list(parseRule);
    }

    @Override
    public APIResponse<List<FileTypeVo>> fileTypeList(FileTypeVo fileTypeVo) {
        return parseRuleService.fileTypeList(fileTypeVo);
    }
}
