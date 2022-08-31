package com.wenwan.web.controller.sort;

import com.wenwan.api.sort.ISortRuleApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.sort.LabelVo;
import com.wenwan.model.sort.SortRuleVo;

import java.util.List;

public class ISortRuleController implements ISortRuleApi {
    @Override
    public APIResponse<Void> insert(SortRuleVo sortRuleVo) {
        return null;
    }

    @Override
    public APIResponse<Void> update(SortRuleVo sortRuleVo) {
        return null;
    }

    @Override
    public APIResponse<SearchResult<SortRuleVo>> list(SortRuleVo sortRuleVo) {
        return null;
    }

    @Override
    public APIResponse<Void> delete(Long id) {
        return null;
    }

    @Override
    public APIResponse<List<LabelVo>> labelList(LabelVo labelVo) {
        return null;
    }
}
