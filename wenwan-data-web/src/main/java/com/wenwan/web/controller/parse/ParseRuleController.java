package com.wenwan.web.controller.parse;

import com.wenwan.api.parse.IParseRuleApi;
import com.wenwan.common.annotation.PassToken;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.BusinessLogVo;
import com.wenwan.model.parse.FileTypeVo;
import com.wenwan.model.parse.ParseRuleVo;
import com.wenwan.model.parse.request.BusinessLogQuery;
import com.wenwan.service.api.parse.ParseRuleService;
import com.wenwan.web.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ParseRuleController extends BaseController implements IParseRuleApi {

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
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<Void> update(ParseRuleVo parseRule) {
        parseRuleService.update(parseRule);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<SearchResult<ParseRuleVo>> list(ParseRuleVo parseRule) {
        return APIResponse.getOkJsonResult(parseRuleService.list(parseRule));
    }

    @Override
    @PassToken
    public APIResponse<List<FileTypeVo>> fileTypeList(FileTypeVo fileTypeVo) {
        return APIResponse.getOkJsonResult(parseRuleService.fileTypeList(fileTypeVo));
    }

    @Override
    public APIResponse<SearchResult<BusinessLogVo>> businessLog(BusinessLogQuery businessLogQuery) {
        return APIResponse.getOkJsonResult(parseRuleService.businessLog(businessLogQuery));
    }
}
