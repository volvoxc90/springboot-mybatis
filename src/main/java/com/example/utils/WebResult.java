package com.example.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhugp
 * @create 2018-03-09 17:22
 *
 * 返回结果
 **/
public class WebResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;//响应状态码

//    private Object result;//响应内容

    private T data;

//    private boolean status;

//    private Object info;//其他信息

    public WebResult() {

    }

    public WebResult(String code, T data) {
        this.data = data;
        this.code = code;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}