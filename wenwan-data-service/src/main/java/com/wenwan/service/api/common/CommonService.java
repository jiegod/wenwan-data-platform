package com.wenwan.service.api.common;

import com.wenwan.model.StaticLabel;

import java.util.Map;
import java.util.Set;

public interface CommonService {

    Map<String, Set<StaticLabel>> getStaticTypeList(String key);
}
