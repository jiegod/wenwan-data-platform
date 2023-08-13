package com.wenwan.service.constant;


import com.google.common.collect.Sets;
import com.wenwan.model.parse.FilterKey;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class TypeCache {

    public static final Set<String> dataSource = new HashSet<>();
    public static final Set<String> fileType = new HashSet<>();
    public static final Set<String> businessLog = new HashSet<>();
    public static final Map<String, Set<String>> allType = new HashMap<>();
    {
        dataSource.addAll(Sets.newHashSet("CNSJ场内数据", "FWPT服务平台", "MAIL项目邮箱", "ZXMAIL归档邮箱", "SZT深圳通")) ;
        fileType.addAll(Sets.newHashSet("CNSJ场内数据", "CWJZ_XX场外净值", "CWQRD场外确认单", "CWYSP场外衍生品", "DWB_XX但外包资金调节表", "DZD_XX对账单"));
        businessLog.addAll(Sets.newHashSet("business_log_cnsj", "business_log_cwjz", "business_log_cwqrd", "business_log_cwysp", "business_log_dwbzj", "business_log_dzd"));
        allType.put(FilterKey.DATASOURCE.name(), dataSource);
        allType.put(FilterKey.BUSINESS_LOG.name(), businessLog);
        allType.put(FilterKey.FILE_TYPE.name(), fileType);
    }

}
