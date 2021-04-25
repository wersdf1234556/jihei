package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 梁工序表
@Table(value = "beamOrders")
public class BeamOrderModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "beamGuid")
    private String beamGuid; // 基础表
    @Column(value = "status")
    private String status; // 工序状态
    @Column(value = "color")
    private String color; // 颜色
    @Column(value = "attTime")
    private String attTime; // 施工日期
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "operator")
    private String operator; // 操作人
    @Column(value = "tenderGuid")
    private String tenderGuid; // 标段
    @NotInsertColumn
    @Column(value = "createdAt")
    private String createdAt;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;

    public BeamOrderModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getBeamGuid() {
        return beamGuid;
    }

    public void setBeamGuid(String beamGuid) {
        this.beamGuid = beamGuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttTime() {
        return attTime;
    }

    public void setAttTime(String attTime) {
        this.attTime = attTime;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
