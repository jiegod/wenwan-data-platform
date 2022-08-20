package com.wenwan.common.aop;

public abstract class BaseAop {

    private final String ALL_METHOD = "execution(* com.wenwan.web.controller.*.* (>>)) or execution(* com.wenwan.api.*.*)";
}
