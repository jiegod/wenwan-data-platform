package com.wenwan.common.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
public abstract class BaseAop {

    public final String CONTROLLER_ALL_METHOD = "execution(* com.wenwan.web.controller.*.*.* (..)) or execution(* com.wenwan.api.*.*.* (..))";

    @Pointcut(CONTROLLER_ALL_METHOD)
    protected void controllerAllMethod() {
    }

    protected String cutArgs(Object[] args) {
        if (args.length > 0){
            String json = JSON.toJSONString(args[0]);
            if (StringUtils.isNotEmpty(json) && json.length() > 1000) {
                return String.format("%s...(total %s) words", json.substring(0, 1000), json.length());
            }
            return json;
        }
        return "no args";
    }
}
