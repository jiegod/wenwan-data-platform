package com.wenwan.service.api;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@Slf4j
public class ConfigCenter implements InitializingBean {

    @Value("${auto.trigger.bulk.size:5000}")
    private Integer triggerSize;
    @Value("${sort.rule.receiver.email:}")
    private List<String> receivers;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[Config Center receivers:{}]", receivers);
        log.info("[Config Center triggerSize:{}]", triggerSize);
    }
}
