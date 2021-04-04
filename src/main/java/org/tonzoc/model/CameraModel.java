package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "cameras")
public class CameraModel extends BaseModel {
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "deviceSerial")
    private String deviceSerial;  // 序列号
    @Column(value = "chanelNo")
    private String chanelNo;  // 通道号
    @Column(value = "name")
    private String name; // 名称
    @Column(value = "status")
    private Integer status;
    @Column(value = "sortId")
    private Integer sortId; // 排序
    @Column(value = "serialNum")
    private Integer serialNum; //总排序
    @Column(value = "topFlag")
    private Integer topFlag; //置顶，0：置顶1：不置顶
    @Column(value = "tenderGuid")
    private String tenderGuid; //标段
    @Column(value = "typeGuid")
    private String typeGuid; //类型
    @Column(value = "purposeGuid")
    private String purposeGuid; //用途guid
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName; //标段
    @JoinColumn(value = "name", type = CameraTypeModel.class, leftColumn = "typeGuid", rightColumn = "guid")
    private String typeName; //类型
    @JoinColumn(value = "name", type = CameraPurposeModel.class, leftColumn = "purposeGuid", rightColumn = "guid")
    private String purposeName; //用途
    @Column(value = "imageUrl")
    private String imageUrl;
    @Column(value = "operator")
    private String operator; // 操作人
    @NotInsertColumn
    @Column(value = "updatedAt")
    private String updatedAt; // 修改时间

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getChanelNo() {
        return chanelNo;
    }

    public void setChanelNo(String chanelNo) {
        this.chanelNo = chanelNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }


    public Integer getTopFlag() {
        return topFlag;
    }

    public void setTopFlag(Integer topFlag) {
        this.topFlag = topFlag;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getTypeGuid() {
        return typeGuid;
    }

    public void setTypeGuid(String typeGuid) {
        this.typeGuid = typeGuid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPurposeGuid() {
        return purposeGuid;
    }

    public void setPurposeGuid(String purposeGuid) {
        this.purposeGuid = purposeGuid;
    }

    public String getPurposeName() {
        return purposeName;
    }

    public void setPurposeName(String purposeName) {
        this.purposeName = purposeName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
