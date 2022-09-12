package com.wenwan.common.exception;

import com.wenwan.common.api.GeneralCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BusinessException extends RuntimeException {

    private ErrorCode errorCode;

    private static final long serialVersionUID = 7577305769394015634L;

    public BusinessException(String msg) {
        super(msg);
        this.errorCode = GeneralCode.SYS_ERROR;
    }
}
