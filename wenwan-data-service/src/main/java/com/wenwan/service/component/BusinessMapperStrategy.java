package com.wenwan.service.component;

import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.BusinessLogVo;
import com.wenwan.model.parse.request.BusinessLogQuery;

public interface BusinessMapperStrategy {

    SearchResult<BusinessLogVo> fetchPatch(BusinessLogQuery businessLogQuery);

    String getType();
}
