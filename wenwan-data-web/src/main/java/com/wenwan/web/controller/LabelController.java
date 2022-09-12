package com.wenwan.web.controller;

import com.wenwan.api.ILabelApi;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.LabelQuery;
import com.wenwan.service.api.LabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LabelController implements ILabelApi {

    @Autowired
    private LabelService labelService;

    @Override
    public APIResponse<SearchResult<String>> list(LabelQuery query) {
        return APIResponse.getOkJsonResult(labelService.list(query));
    }
}
