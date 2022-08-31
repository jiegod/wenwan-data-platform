package com.wenwan.web.controller.sort;

import com.wenwan.api.sort.ISortApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.sort.TriggerSortVo;
import com.wenwan.model.sort.SourceFileVo;

public class ISortController implements ISortApi {
    @Override
    public APIResponse<SearchResult<SourceFileVo>> list(SourceFileVo sourceFileVo) {
        return null;
    }

    @Override
    public APIResponse<String> trigger(TriggerSortVo triggerSortVo) {
        return null;
    }
}
