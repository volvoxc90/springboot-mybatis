package com.example.domain;

import java.io.Serializable;

public class EquipRepair extends BaseEntity implements Serializable {

    private Integer id;

    private Integer equipInfoId;

    private String equipName;

    private String typeName;

    private Integer typeId;

    private String repairPoint;

    private String repairer;

    private String repairTime;

    private String failureCause;

    private String remark;

    private String repairFinishTime;

    // 开始日期
    private String beginTime;
    // 结束日期
    private String endTime;

    // 设备状态 (1:空闲，2：报废，3：维修，4：借出)
    private Integer status;

    public String getRepairFinishTime() {
        return repairFinishTime;
    }

    public void setRepairFinishTime(String repairFinishTime) {
        this.repairFinishTime = repairFinishTime;
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

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipInfoId() {
        return equipInfoId;
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

    public void setEquipInfoId(Integer equipInfoId) {
        this.equipInfoId = equipInfoId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getRepairPoint() {
        return repairPoint;
    }

    public void setRepairPoint(String repairPoint) {
        this.repairPoint = repairPoint;
    }

    public String getRepairer() {
        return repairer;
    }

    public void setRepairer(String repairer) {
        this.repairer = repairer;
    }

    public String getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime;
    }

    public String getFailureCause() {
        return failureCause;
    }

    public void setFailureCause(String failureCause) {
        this.failureCause = failureCause;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EquipRepair{" +
                "id=" + id +
                ", equipInfoId=" + equipInfoId +
                ", equipName='" + equipName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeId=" + typeId +
                ", repairPoint='" + repairPoint + '\'' +
                ", repairer='" + repairer + '\'' +
                ", repairTime='" + repairTime + '\'' +
                ", failureCause='" + failureCause + '\'' +
                ", remark='" + remark + '\'' +
                ", repairFinishTime='" + repairFinishTime + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status=" + status +
                '}';
    }
}