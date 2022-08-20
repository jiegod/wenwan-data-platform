package com.wenwan.api.parse;

import com.wenwan.common.api.APIResponse;
import com.wenwan.model.parse.WwDataParseRule;
import org.springframework.web.bind.annotation.RequestBody;

public interface IModelDesignApi {

    APIResponse<Void> insert(@RequestBody WwDataParseRule parseRule);
}
