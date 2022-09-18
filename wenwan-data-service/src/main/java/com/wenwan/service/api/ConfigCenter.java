package com.wenwan.service.api;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConfigCenter {

    @Value("${auto.trigger.bulk.size:5000}")
    private Integer triggerSize;
}
