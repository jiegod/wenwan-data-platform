package com.wenwan.service.impl;

import com.wenwan.common.api.SearchResult;
import com.wenwan.model.sort.LabelVo;
import com.wenwan.model.sort.SortRuleVo;
import com.wenwan.service.api.BaseService;
import com.wenwan.service.api.sort.SortRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortRuleServiceImpl extends BaseService implements SortRuleService {

    @Override
    public Integer insert(SortRuleVo sortRuleVo) {

        return null;
    }

    @Override
    public Integer update(SortRuleVo sortRuleVo) {
        return null;
    }

    @Override
    public SearchResult<SortRuleVo> list(SortRuleVo sortRuleVo) {
        return null;
    }

    @Override
    public Integer delete(Long id) {
        return null;
    }

    @Override
    public List<LabelVo> labelList(LabelVo labelVo) {
        return null;
    }
}
