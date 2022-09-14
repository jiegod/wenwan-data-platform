package com.wenwan.api.user;

import com.alibaba.fastjson.JSONObject;
import com.wenwan.common.annotation.PassToken;
import com.wenwan.common.api.APIResponse;
import com.wenwan.common.api.SearchResult;
import com.wenwan.model.sort.SourceFileVo;
import com.wenwan.model.sort.TriggerSortVo;
import com.wenwan.model.user.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@Api(description = "用户相关api")
public interface IUserApi {

    @PostMapping("/login")
    @ApiOperation("登录")
    @PassToken
    APIResponse<JSONObject> login(@RequestBody @Valid UserVo userVo, HttpServletResponse response);
}
