package com.wenwan.service.api;

import com.wenwan.common.api.SearchResult;
import com.wenwan.model.LabelQuery;

public interface LabelService {

    SearchResult<String> list(LabelQuery query);
}
