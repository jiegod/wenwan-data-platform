package com.wenwan.common.constant;

import com.wenwan.common.exception.ErrorCode;

public enum GeneralCode implements ErrorCode {
    SUCCESS("00000000", "SUCCESS"),
    SYS_ERROR("10001001", "system error"),
    SYS_VALID("10001002", "check valid"),

    USER_ERROR("20000000","username or password error"),
    USER_NOT_EXIT("20000001","user not exit, please login again"),
    USER_NOT_LOGIN("20000401", "you have not login, please login first");

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
