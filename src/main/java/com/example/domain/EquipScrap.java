package com.example.domain;


import java.io.Serializable;

public class EquipScrap extends BaseEntity implements Serializable {
    private Integer id;

    private Integer equipInfoId;

    private String equipName;

    private String typeName;

    private Integer typeId;

    private String scrapTime;

    private String scrapCause;

    private Double ioCost;

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

    public String getScrapTime() {
        return scrapTime;
    }

    public void setScrapTime(String scrapTime) {
        this.scrapTime = scrapTime;
    }

    public String getScrapCause() {
        return scrapCause;
    }

    public void setScrapCause(String scrapCause) {
        this.scrapCause = scrapCause;
    }

    public Double getIoCost() {
        return ioCost;
    }

    public void setIoCost(Double ioCost) {
        this.ioCost = ioCost;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EquipScrap{" +
                "id=" + id +
                ", equipInfoId=" + equipInfoId +
                ", equipName='" + equipName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeId=" + typeId +
                ", scrapTime='" + scrapTime + '\'' +
                ", scrapCause='" + scrapCause + '\'' +
                ", ioCost=" + ioCost +
                ", status=" + status +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}