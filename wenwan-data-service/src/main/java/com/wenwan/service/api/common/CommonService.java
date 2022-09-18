package com.wenwan.service.api.common;

import com.wenwan.model.StaticLabel;

import java.util.List;
import java.util.Map;

public interface CommonService {

    Map<String, List<StaticLabel>> getStaticTypeList(String key);
}
