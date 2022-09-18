package com.wenwan.service.api.sort;

import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.dao.entity.SortRule;
import com.wenwan.model.sort.LabelVo;
import com.wenwan.model.sort.SortRuleVo;

import java.util.List;

public interface SortRuleService {

    Integer insert(SortRuleVo sortRuleVo);
    Integer update(SortRuleVo sortRuleVo);
    SearchResult<SortRuleVo> list(SortRuleVo sortRuleVo);
    Integer delete(Long id);
    List<LabelVo> labelList(LabelVo labelVo);
    List<SortRule> getALLSortRule();
    List<SortRule> getSortRuleByDate(Integer operateDate);
}
