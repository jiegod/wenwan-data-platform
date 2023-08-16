package com.wenwan.service.impl;

import com.wenwan.common.constant.CommonConst;
import com.wenwan.model.StaticLabel;
import com.wenwan.service.api.ConfigCenter;
import com.wenwan.service.api.common.CommonService;
import com.wenwan.service.constant.TypeCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommonServiceImpl extends ConfigCenter implements CommonService {

    @Override
    public Map<String, Set<StaticLabel>> getStaticTypeList(String key) {
        Map<String, Set<StaticLabel>> result = new HashMap<>();
        result.put(CommonConst.RECEIVER_EMAIL, getReceivers().stream().map(s ->
            new StaticLabel(s, s)).collect(Collectors.toSet()));
        result.put(CommonConst.DATASOURCE, TypeCache.dataSource);
        result.put(CommonConst.FILE_TYPE, TypeCache.fileType);
        result.put(CommonConst.BUSINESS_LOG, TypeCache.businessLog);
        return result;
    }
}
