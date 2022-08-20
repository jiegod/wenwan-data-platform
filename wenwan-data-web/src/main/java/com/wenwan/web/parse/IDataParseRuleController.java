package com.wenwan.web.parse;

import com.wenwan.api.parse.IDataParseRuleApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.WwDataParseRuleDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IDataParseRuleController implements IDataParseRuleApi {

    @Override
    public APIResponse<String> insert(WwDataParseRuleDto parseRule) {
        return null;
    }

    @Override
    public APIResponse<String> delete(Long id) {
        return null;
    }

    @Override
    public APIResponse<String> update(WwDataParseRuleDto parseRule) {
        return null;
    }

    @Override
    public APIResponse<SearchResult<WwDataParseRuleDto>> list(WwDataParseRuleDto parseRule) {
        return null;
    }
}
