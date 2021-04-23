package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 梁场摄像头
@Table("BeamCameras")
public class BeamCameraModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "deviceSerial")
    private String deviceSerial;
    @Column(value = "chanelNo")
    private String chanelNo;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "typeGuid")
    private String typeGuid;
    @Column(value = "beamType")
    private String beamType; // 摄像头是谁的

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "typeGuid", rightColumn = "guid")
    private String tenderName;

    public BeamCameraModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getTypeGuid() {
        return typeGuid;
    }

    public void setTypeGuid(String typeGuid) {
        this.typeGuid = typeGuid;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getBeamType() {
        return beamType;
    }

    public void setBeamType(String beamType) {
        this.beamType = beamType;
    }
}


