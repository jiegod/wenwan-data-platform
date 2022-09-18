package com.wenwan.web.controller;

import com.wenwan.api.ICommonService;
import com.wenwan.common.api.APIResponse;
import com.wenwan.model.StaticLabel;
import com.wenwan.service.api.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CommonController implements ICommonService {

    @Autowired
    private CommonService commonService;

    @Override
    public APIResponse<Map<String, List<StaticLabel>>> list(String key) {
        return APIResponse.getOkJsonResult(commonService.getStaticTypeList(key));
    }
}
