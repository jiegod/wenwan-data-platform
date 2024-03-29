package com.wenwan.web.aop;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wenwan.common.annotation.PassToken;
import com.wenwan.common.aop.BaseAop;
import com.wenwan.common.constant.GeneralCode;
import com.wenwan.common.constant.UserConst;
import com.wenwan.common.exception.BusinessException;
import com.wenwan.mysql.dao.entity.User;
import com.wenwan.service.api.user.UserService;
import com.wenwan.service.util.RequestUtils;
import com.wenwan.service.util.TokenUtil;
import com.wenwan.service.util.UserStorage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Order(2)
@Slf4j
public class AuthenticationAop extends BaseAop {

    @Autowired
    UserService userService;
    @Value("${auth.env:}")
    private String authEnv;

    @Around(value = "controllerAllMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        String userName = null;
        Object o;
        if (!"DEV".equals(authEnv)) {
            Method method = ((MethodSignature) pjp.getSignature()).getMethod();
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken != null && passToken.required()) {
                log.info("[authentication] this is white path");
            } else {
                String token = RequestUtils.getRequest().getHeader(UserConst.TOKEN);
                try {
                    userName = TokenUtil.getTokenUser();// 从 http 请求头中取出 token
                } catch (JWTDecodeException j) {
                    throw new BusinessException(GeneralCode.USER_NOT_LOGIN);
                }
                if (StringUtils.isEmpty(userName)) {
                    throw new BusinessException(GeneralCode.USER_NOT_LOGIN);
                }
                User user = userService.getUserInfo(userName);
                if (user == null) {
                    throw new BusinessException(GeneralCode.USER_NOT_EXIT);
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new BusinessException(GeneralCode.USER_NOT_LOGIN);
                }
            }
        } else {
            userName = "jack";
        }

        try {
            if (StringUtils.isNotEmpty(userName)) {
                UserStorage.set(userName);
            }
            o = pjp.proceed(pjp.getArgs());
        } catch (Exception e) {
            log.error("[AuthenticationAop] error.", e);
            throw new BusinessException(e.getMessage());
        } finally {
            UserStorage.remove();
        }
        return o;
    }
}
