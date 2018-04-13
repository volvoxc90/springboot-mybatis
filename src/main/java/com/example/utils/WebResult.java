package com.example.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhugp
 * @create 2018-03-09 17:22
 **/
@Data
public class WebResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;//响应状态码

    private Object result;//响应内容

    private Object info;//其他信息

    public WebResult() {
    }

    public WebResult(String code, Object result) {
        this.code = code;
        this.result = result;
    }
}