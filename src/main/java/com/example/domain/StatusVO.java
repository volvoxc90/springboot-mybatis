package com.example.domain;


import java.io.Serializable;

public class StatusVO  implements Serializable {

    private Integer free;

    private Integer repair;

    private Integer scrap;

    private Integer borrow;

    public Integer getFree() {
        return free;
    }

    public void setFree(Integer free) {
        this.free = free;
    }

    public Integer getRepair() {
        return repair;
    }

    public void setRepair(Integer repair) {
        this.repair = repair;
    }

    public Integer getScrap() {
        return scrap;
    }

    public void setScrap(Integer scrap) {
        this.scrap = scrap;
    }

    public Integer getBorrow() {
        return borrow;
    }

    public void setBorrow(Integer borrow) {
        this.borrow = borrow;
    }
}