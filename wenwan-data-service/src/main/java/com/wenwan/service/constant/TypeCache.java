package com.wenwan.service.constant;


import com.google.common.collect.Sets;
import com.wenwan.model.StaticLabel;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Data
@Configuration
public class TypeCache {

    public static final Set<StaticLabel> dataSource = new HashSet<>();
    public static final Set<StaticLabel> fileType = new HashSet<>();
    public static final Set<StaticLabel> businessLog = new HashSet<>();

    @PostConstruct
    public void init() {
        dataSource.addAll(Sets.newHashSet(
                new StaticLabel("CNSJ", "CNSJ场内数据"),
                new StaticLabel("FWPT", "FWPT服务平台"),
                new StaticLabel("MAIL", "MAIL项目邮箱"),
                new StaticLabel("ZXMAIL", "ZXMAIL归档邮箱"),
                new StaticLabel("SZT", "SZT深圳通")));
        fileType.addAll(Sets.newHashSet(
                new StaticLabel("CNSJ", "CNSJ场内数据"),
                new StaticLabel("CWJZ_XX", "CWJZ_XX场外净值"),
                new StaticLabel("CWQR", "CWQRD场外确认单"),
                new StaticLabel("CWYSP", "CWYSP场外衍生品"),
                new StaticLabel("DWB_XX", "DWB_XX但外包资金调节表"),
                new StaticLabel("DZD_XX", "DZD_XX对账单")));
        businessLog.addAll(Sets.newHashSet(
                new StaticLabel("business_log_cnsj", "business_log_cnsj"),
                new StaticLabel("business_log_cwjz", "business_log_cwjz"),
                new StaticLabel("business_log_cwqrd", "business_log_cwqrd"),
                new StaticLabel("business_log_cwysp", "business_log_cwysp"),
                new StaticLabel("business_log_dwbzj", "business_log_dwbzj"),
                new StaticLabel("business_log_dzd", "business_log_dzd")));
    }

}
