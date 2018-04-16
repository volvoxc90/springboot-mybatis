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

    private String username;

    private Integer age;

    private  String ctm;
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
