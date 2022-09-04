package com.wenwan.common.api;

public class APIResponse<T> extends ToString {

    private static final long serialVersionUID = 8708468057904019710L;

    private static APIResponse<?> OK = new APIResponse<>(Status.OK, Type.GENERAL, GeneralCode.SUCCESS.getCode());
    private Status status;
    private Type type = Type.GENERAL;
    private String code;
    private Object errorData;
    private T data;
    private Object[] params;

    public Status getStatus() {
        return status;
    }

    public Type getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public Object getErrorData() {
        return errorData;
    }

    public T getData() {
        return data;
    }

    public Object[] getParams() {
        return params;
    }

    public static enum Status {
        OK, ERROR
    }

    public static enum Type {
        SYS, GENERAL, VALID
    }

    public APIResponse(Status status, String code) {
        super();
        this.status = status;
        this.code = code;
    }

    public APIResponse(Status status, Type type, String code) {
        super();
        this.status = status;
        this.code = code;
        this.type = type;
    }

    public APIResponse(Status status, Type type, String code, T data) {
        super();
        this.status = status;
        this.code = code;
        this.type = type;
        this.data = data;
    }

    public static <T> APIResponse<T> getOkJsonResult() {
        APIResponse<T> result = new APIResponse<>(Status.OK, Type.GENERAL, GeneralCode.SUCCESS.getCode());
        return result;
    }

    public static <T> APIResponse<T> getOkJsonResult(T data) {
        APIResponse<T> result = new APIResponse<>(Status.OK, Type.GENERAL, GeneralCode.SUCCESS.getCode(), data);
        return result;
    }

    public static <T> APIResponse<T> getErrorJsonResult(Object errorData) {
        APIResponse<T> result = new APIResponse(Status.ERROR, Type.GENERAL, GeneralCode.SYS_ERROR.getCode(), errorData);
        return result;
    }
}
