package com.wenwan.web.aop;

import com.wenwan.common.aop.BaseAop;
import com.wenwan.common.api.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@Order(1)
@Slf4j
public class ControllerTraceLogAop extends BaseAop {

    @Around(value = "controllerAllMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        String clz = pjp.getSignature().getDeclaringTypeName();
        String method = pjp.getSignature().getName();
        String args = cutArgs(pjp.getArgs());
        log.info("{} {} start. request:{}", clz, method, args);
        long ms = new Date().getTime();
        try {
            Object result = pjp.proceed();
            log.info("{} {} done. cost:{}ms, request:{}", clz, method, new Date().getTime() - ms, args);
            return result;
        }catch (Exception e){
            log.error("{} {} done. cost:{}ms, request:{}", clz, method, new Date().getTime() - ms, args, e);
            return APIResponse.getErrorJsonResult(e.getMessage());
        }
    }
}
