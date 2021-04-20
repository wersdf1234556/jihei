package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 梁的基础表
@Table("beams")
public class BeamModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "beamPedestalGuid")
    private String beamPedestalGuid;
    @Column(value = "beamPrefabricationGuid")
    private String beamPrefabricationGuid;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "attTime")
    private String attTime;
    @Column(value = "operator")
    private String operator;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    private String status; // 状态

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;
    @JoinColumn(value = "status", type = BeamPedestalModel.class, leftColumn = "beamPedestalGuid", rightColumn = "guid")
    private String beamPedestalStatus;
    @JoinColumn(value = "name", type = BeamPedestalModel.class, leftColumn = "beamPedestalGuid", rightColumn = "guid")
    private String beamPedestalName;
    @JoinColumn(value = "status", type = BeamPrefabricationModel.class, leftColumn = "beamPrefabricationGuid", rightColumn = "guid")
    private String beamPrefabricationStatus;
    @JoinColumn(value = "name", type = BeamPrefabricationModel.class, leftColumn = "beamPrefabricationGuid", rightColumn = "guid")
    private String beamPrefabricationName;

    public BeamModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getBeamPedestalGuid() {
        return beamPedestalGuid;
    }

    public void setBeamPedestalGuid(String beamPedestalGuid) {
        this.beamPedestalGuid = beamPedestalGuid;
    }

    public String getBeamPrefabricationGuid() {
        return beamPrefabricationGuid;
    }

    public void setBeamPrefabricationGuid(String beamPrefabricationGuid) {
        this.beamPrefabricationGuid = beamPrefabricationGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getBeamPedestalName() {
        return beamPedestalName;
    }

    public void setBeamPedestalName(String beamPedestalName) {
        this.beamPedestalName = beamPedestalName;
    }

    public String getBeamPrefabricationName() {
        return beamPrefabricationName;
    }

    public void setBeamPrefabricationName(String beamPrefabricationName) {
        this.beamPrefabricationName = beamPrefabricationName;
    }

    public String getAttTime() {
        return attTime;
    }

    public void setAttTime(String attTime) {
        this.attTime = attTime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBeamPedestalStatus() {
        return beamPedestalStatus;
    }

    public void setBeamPedestalStatus(String beamPedestalStatus) {
        this.beamPedestalStatus = beamPedestalStatus;
    }

    public String getBeamPrefabricationStatus() {
        return beamPrefabricationStatus;
    }

    public void setBeamPrefabricationStatus(String beamPrefabricationStatus) {
        this.beamPrefabricationStatus = beamPrefabricationStatus;
    }
}