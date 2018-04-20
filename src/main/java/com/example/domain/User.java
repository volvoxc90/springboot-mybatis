package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhugp
 * @create 2018-03-16 11:44
 **/
public class User extends BaseEntity implements Serializable {

    private Integer id;

    private String username;

    private Integer age;

    private  String ctm;

    private String contactAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCtm() {
        return ctm;
    }

    public void setCtm(String ctm) {
        this.ctm = ctm;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", ctm='" + ctm + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                '}';
    }
}
