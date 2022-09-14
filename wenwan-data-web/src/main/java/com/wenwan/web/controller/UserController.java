package com.wenwan.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.wenwan.api.user.IUserApi;
import com.wenwan.common.annotation.PassToken;
import com.wenwan.common.api.APIResponse;
import com.wenwan.model.user.UserVo;
import com.wenwan.service.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController implements IUserApi {

    @Autowired
    private UserService userService;

    @Override
    @PassToken
    public APIResponse<JSONObject> login(UserVo userVo, HttpServletResponse response) {
        return APIResponse.getOkJsonResult(userService.login(userVo, response));
    }
}
