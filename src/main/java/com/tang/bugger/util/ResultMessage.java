package com.tang.bugger.util;

import java.io.Serializable;

public class ResultMessage<T> implements Serializable{

    private String message;
    private Integer code;
    private T data;

    public ResultMessage(Integer code, String message,T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
