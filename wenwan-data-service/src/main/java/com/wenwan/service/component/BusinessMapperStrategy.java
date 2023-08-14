package com.wenwan.service.component;

import com.wenwan.common.api.SearchResult;
import com.wenwan.model.parse.BusinessLogVo;
import com.wenwan.model.parse.request.BusinessLogQuery;
import com.wenwan.service.constant.BusinessLogType;

public interface BusinessMapperStrategy {

    SearchResult<BusinessLogVo> fetchPatch(BusinessLogQuery businessLogQuery);

    BusinessLogType getName();
}
