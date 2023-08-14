package com.wenwan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.common.constant.GeneralCode;
import com.wenwan.common.exception.BusinessException;
import com.wenwan.mysql.dao.entity.User;
import com.wenwan.model.request.ListQuery;
import com.wenwan.model.user.UserVo;
import com.wenwan.service.api.MapperConfigService;
import com.wenwan.service.api.user.TokenService;
import com.wenwan.service.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceConfigImpl extends MapperConfigService<User, ListQuery> implements UserService {

    @Autowired
    private TokenService tokenService;

    @Override
    public JSONObject login(UserVo userVo, HttpServletResponse response) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class)
                .eq(User::getUsername, userVo.getUsername())
                .eq(User::getPassword, userVo.getPassword());
        User user = userMapper.selectOne(wrapper);
        if (user == null) {
            throw new BusinessException(GeneralCode.USER_ERROR);
        }
        String token = tokenService.getToken(userVo);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", token);
        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        response.addCookie(cookie);
        return jsonObject;
    }

    @Override
    public User getUserInfo(String username) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class)
                .eq(User::getUsername, username);
        return userMapper.selectOne(wrapper);
    }
}
