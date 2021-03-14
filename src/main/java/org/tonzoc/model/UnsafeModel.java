package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 安全隐患表
@Table("unsafes")
public class UnsafeModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "unsafeTypeGuid")
    private String unsafeTypeGuid; // 安全等级
    @Column(value = "parts")
    private String parts; // 部位
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "stakeName")
    private String stakeName; // 桩号名称
    @Column(value = "riskType")
    private String riskType; // 风险类型
    @Column(value = "measures")
    private String measures; // 防控措施
    @Column(value = "describe")
    private String describe; // 风险点简单描述
    @Column(value = "sortId")
    private String sortId;
    @Column(value = "lng")
    private String lng;
    @Column(value = "lat")
    private String lat;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段单位名称
    @JoinColumn(value = "name", type = UnsafeTypeModel.class, leftColumn = "unsafeTypeGuid", rightColumn = "guid")
    private String UnsafeTypeName;  // 等级名称
    @JoinColumn(value = "uname", type = UnsafeTypeModel.class, leftColumn = "unsafeTypeGuid", rightColumn = "guid")
    private String UnsafeTypeUName;  // 等级另一个名称

    public UnsafeModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUnsafeTypeGuid() {
        return unsafeTypeGuid;
    }

    public void setUnsafeTypeGuid(String unsafeTypeGuid) {
        this.unsafeTypeGuid = unsafeTypeGuid;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getStakeName() {
        return stakeName;
    }

    public void setStakeName(String stakeName) {
        this.stakeName = stakeName;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
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

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getUnsafeTypeName() {
        return UnsafeTypeName;
    }

    public void setUnsafeTypeName(String unsafeTypeName) {
        UnsafeTypeName = unsafeTypeName;
    }

    public String getUnsafeTypeUName() {
        return UnsafeTypeUName;
    }

    public void setUnsafeTypeUName(String unsafeTypeUName) {
        UnsafeTypeUName = unsafeTypeUName;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "UnsafeModel{" +
                "guid='" + guid + '\'' +
                ", unsafeTypeGuid='" + unsafeTypeGuid + '\'' +
                ", parts='" + parts + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", stakeName='" + stakeName + '\'' +
                ", riskType='" + riskType + '\'' +
                ", measures='" + measures + '\'' +
                ", describe='" + describe + '\'' +
                ", sortId='" + sortId + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", tenderName='" + tenderName + '\'' +
                ", UnsafeTypeName='" + UnsafeTypeName + '\'' +
                ", UnsafeTypeUName='" + UnsafeTypeUName + '\'' +
                '}';
    }
}
