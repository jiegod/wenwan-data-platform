package com.wenwan.common.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIRequest<T> extends ToString{

    private static final long serialVersionUID = 3133894711720935656L;

    private T body;

    public static <T> APIRequest<T> instance(T body){
        APIRequest<T> request = new APIRequest<>();
        request.setBody(body);
        return request;
    }

}
