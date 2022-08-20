package com.wenwan.web.controller.sort;

import com.wenwan.api.sort.ISortRuleApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.sort.WwSortRule;

public class ISortRuleController implements ISortRuleApi {
    @Override
    public APIResponse<String> insert(WwSortRule sortRule) {
        return null;
    }

    @Override
    public APIResponse<String> update(WwSortRule sortRule) {
        return null;
    }

    @Override
    public APIResponse<SearchResult<WwSortRule>> list(WwSortRule sortRule) {
        return null;
    }

    @Override
    public APIResponse<String> delete(Long id) {
        return null;
    }
}
