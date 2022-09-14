package com.wenwan.service.util;

import com.auth0.jwt.JWT;
import org.apache.commons.lang3.StringUtils;

public class TokenUtil {

    public static String getTokenUser() {
        String token = RequestUtils.getRequest().getHeader("token");// 从 http 请求头中取出 token
        if (StringUtils.isEmpty(token)){
            return null;
        }
        String userId = JWT.decode(token).getAudience().get(0);
        return userId;
    }

    /**
     * 获取request
     * @return
     */

}
