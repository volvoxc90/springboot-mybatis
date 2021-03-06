package com.example.domain;

import java.io.Serializable;


public class EquipInfoVO extends BaseEntity implements Serializable {
    //设备id
    private Integer id;
    //设备名称
    private String name;
    private String equipName;
    //类型名称 常用类、普通类、闲杂类
    private String typeName;
    // 设备型号
    private String typeNo;
    // 设备序列号
    private int serialNo;
    // 出厂日期
    private String factoryTime;
    // 图片路径
    private String fileData;

    // 设备类型
    private int typeId;
    // 设备品牌(牌名)
    private String brand;
    // 生产厂家
    private String factory;
    // 购买时间
    private String buyTime;
    // 备注
    private String remark;
    // 开始日期
    private String beginTime;
    // 结束日期
    private String endTime;
    // 设备状态 (1:空闲，2：报废，3：维修，4：借出)
    private int status;


    private String createTime;
    private String updateTime;

    private User user;

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EquipVO{" +
                "id='" + id + '\'' +
                "equipName='" + equipName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeNo='" + typeNo + '\'' +
                ", serialNo=" + serialNo +
                ", factoryTime='" + factoryTime + '\'' +
                ", fileData='" + fileData + '\'' +
                ", typeId=" + typeId +
                ", brand='" + brand + '\'' +
                ", factory='" + factory + '\'' +
                ", buyTime='" + buyTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", remark='" + remark + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getFactoryTime() {
        return factoryTime;
    }

    public void setFactoryTime(String factoryTime) {
        this.factoryTime = factoryTime;
    }

    public String getFileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}