package com.wenwan.service.api.user;

import com.alibaba.fastjson.JSONObject;
import com.wenwan.dao.entity.User;
import com.wenwan.model.user.UserVo;

import javax.servlet.http.HttpServletResponse;

public interface UserService {

    JSONObject login(UserVo userVo, HttpServletResponse response);

    User getUserInfo(String username);
}
