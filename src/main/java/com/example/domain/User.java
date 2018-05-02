package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @create 2018-03-16 11:44
 **/
public class User extends BaseEntity implements Serializable {

    private Integer id;

    private String userName;

    private Integer age;

    private String ctm;

    private String contactAddress;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", ctm='" + ctm + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", status=" + status +
                '}';
    }
}
