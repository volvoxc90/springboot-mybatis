package com.example.domain;

import java.io.Serializable;


public class EquipBorrowReturn extends BaseEntity implements Serializable {

    private Integer id;

    private Integer equipInfoId;

    private String equipName;

    private String typeName;

    private Integer typeId;

    private String borrower;

    private String borrowTime;

    private String returnTime;

    private Double borrowDay;

    private Integer status;

    // 开始日期
    private String beginTime;
    // 结束日期
    private String endTime;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getEquipInfoId() {
        return equipInfoId;
    }

    public void setEquipInfoId(Integer equipInfoId) {
        this.equipInfoId = equipInfoId;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Double getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(Double borrowDay) {
        this.borrowDay = borrowDay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EquipBorrowReturn{" +
                "id=" + id +
                ", equipInfoId=" + equipInfoId +
                ", equipName='" + equipName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeId=" + typeId +
                ", borrower='" + borrower + '\'' +
                ", borrowTime='" + borrowTime + '\'' +
                ", returnTime='" + returnTime + '\'' +
                ", borrowDay=" + borrowDay +
                ", status=" + status +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}