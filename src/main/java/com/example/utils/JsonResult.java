package com.example.utils;

import lombok.Data;

/**
 * @author zhugp
 * @create 2018-03-09 17:01
 **/
@Data
public class JsonResult {

    private String status;

    private Object result;

    public JsonResult status(String stauts) {
        this.status = stauts;
         return this;
    }

}