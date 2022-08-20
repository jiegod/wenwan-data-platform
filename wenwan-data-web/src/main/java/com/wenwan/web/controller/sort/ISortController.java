package com.wenwan.web.controller.sort;

import com.wenwan.api.sort.ISortApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.dto.SourceFileDto;
import com.wenwan.model.dto.TriggerSortDto;
import com.wenwan.model.request.sort.SourceFileRequest;

public class ISortController implements ISortApi {
    @Override
    public APIResponse<SearchResult<SourceFileDto>> fileList(SourceFileRequest searchRequest) {
        return null;
    }

    @Override
    public APIResponse<String> trigger(TriggerSortDto sort) {
        return null;
    }

    @Override
    public APIResponse<SourceFileDto> detail(Long id) {
        return null;
    }
}
