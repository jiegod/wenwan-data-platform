package com.wenwan.common.api;

import com.wenwan.common.exception.ErrorCode;

public enum GeneralCode implements ErrorCode {
    SUCCESS("00000000", "正常"),
    SYS_ERROR("10001001", "系统异常"),
    SYS_VALID("10001002", "验证不通过");

    private String code;
    private String message;

    private GeneralCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
