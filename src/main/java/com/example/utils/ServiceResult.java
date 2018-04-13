package com.example.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhugp
 * @create 2018-03-09 17:22
 **/
@Data
public class ServiceResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code; //响应状态码

    private String message; // 响应说明

    private T result; // 响应内容

    public ServiceResult() {
    }

    public ServiceResult(String code, T result) {
        this.code = code;
        this.result = result;
    }
}