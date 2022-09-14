package com.wenwan.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wenwan.model.user.UserVo;
import com.wenwan.service.api.user.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String getToken(UserVo user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 30L * 24 * 60* 60 * 1000;//30天有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getUsername()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
