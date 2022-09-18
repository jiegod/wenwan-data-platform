package com.wenwan.web.controller.sort;

import com.wenwan.api.sort.ISortRuleApi;
import com.wenwan.common.annotation.PassToken;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.sort.LabelVo;
import com.wenwan.model.sort.SortRuleVo;
import com.wenwan.service.api.sort.SortRuleService;
import com.wenwan.web.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class SortRuleController extends BaseController implements ISortRuleApi {
    
    @Autowired
    private SortRuleService sortRuleService;
    @Override
    public APIResponse<String> insert(SortRuleVo sortRuleVo) {
        sortRuleService.insert(sortRuleVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<String> update(SortRuleVo sortRuleVo) {
        sortRuleService.update(sortRuleVo);
        return APIResponse.getOkJsonResult();
    }

    @Override
    public APIResponse<SearchResult<SortRuleVo>> list(SortRuleVo sortRuleVo) {
        return APIResponse.getOkJsonResult(sortRuleService.list(sortRuleVo));
    }

    @Override
    public APIResponse<String> delete(Long id) {
        sortRuleService.delete(id);
        return APIResponse.getOkJsonResult();
    }

    @Override
    @PassToken
    public APIResponse<List<LabelVo>> labelList(LabelVo labelVo) {
        return APIResponse.getOkJsonResult(sortRuleService.labelList(labelVo));
    }
}
