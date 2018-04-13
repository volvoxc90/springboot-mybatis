package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhugp
 * @create 2018-03-16 11:44
 **/
@Data
public class User implements Serializable {

    private Integer id;

    private String userName;

    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}