package com.wenwan.api.result;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "dashboard相关api")
@RequestMapping("api/v1/dashboard")
public interface IDashboardApi {
}
