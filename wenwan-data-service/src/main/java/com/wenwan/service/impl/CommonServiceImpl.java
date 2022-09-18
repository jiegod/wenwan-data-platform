package com.wenwan.service.impl;

import com.wenwan.common.constant.CommonConst;
import com.wenwan.model.StaticLabel;
import com.wenwan.model.enums.Datasource;
import com.wenwan.service.api.ConfigCenter;
import com.wenwan.service.api.common.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommonServiceImpl extends ConfigCenter implements CommonService {

    @Override
    public Map<String, List<StaticLabel>> getStaticTypeList(String key) {
        Map<String, List<StaticLabel>> result = new HashMap<>();
        result.put(CommonConst.RECEIVER_EMAIL, getReceivers().stream().map(s ->
            new StaticLabel(s, s)).collect(Collectors.toList()));
        result.put(CommonConst.DATASOURCE, Datasource.getDatasourceLabel());
        return result;
    }
}
