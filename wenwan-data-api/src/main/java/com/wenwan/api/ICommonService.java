package com.wenwan.api;

import com.wenwan.common.api.APIResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/common")
@Api(description = "枚举等通用api")
public interface ICommonService {

    @GetMapping("/enum/")
    @ApiOperation("枚举类api")
    APIResponse<Map<String, List<String>>> list(@RequestParam(required = false) String key);
}
