package com.wenwan.service.api.user;

import com.wenwan.model.user.UserVo;

public interface TokenService {

    String getToken(UserVo user);
}
