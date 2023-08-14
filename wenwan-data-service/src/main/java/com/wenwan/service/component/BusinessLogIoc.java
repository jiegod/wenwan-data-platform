package com.wenwan.service.component;

import com.wenwan.service.constant.BusinessLogType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class BusinessLogIoc {

    @Bean
    public Map<BusinessLogType, BusinessMapperStrategy> businessLog(List<BusinessMapperStrategy> businessMapperStrategyList) {
        return businessMapperStrategyList.stream().collect(Collectors.toMap(BusinessMapperStrategy::getName, Function.identity()));
    }
}
