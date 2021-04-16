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
    @Column(value = "concreteStrengthOne")
    private Integer concreteStrengthOne; // 混凝土强度1
    @Column(value = "concreteStrengthTwo")
    private Integer concreteStrengthTwo; // 混凝土强度2
    @Column(value = "concreteStrengthThree")
    private Integer concreteStrengthThree; // 混凝土强度3
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "remarks")
    private String remarks;
    @Column(value = "attTime")
    private String attTime;
    @Column(value = "operator")
    private String operator;
    @Column(value = "tenderGuid")
    private String tenderGuid;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;
    @JoinColumn(value = "name", type = BeamPedestalModel.class, leftColumn = "beamPedestalGuid", rightColumn = "guid")
    private String beamPedestalName;
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

    public Integer getConcreteStrengthOne() {
        return concreteStrengthOne;
    }

    public void setConcreteStrengthOne(Integer concreteStrengthOne) {
        this.concreteStrengthOne = concreteStrengthOne;
    }

    public Integer getConcreteStrengthTwo() {
        return concreteStrengthTwo;
    }

    public void setConcreteStrengthTwo(Integer concreteStrengthTwo) {
        this.concreteStrengthTwo = concreteStrengthTwo;
    }

    public Integer getConcreteStrengthThree() {
        return concreteStrengthThree;
    }

    public void setConcreteStrengthThree(Integer concreteStrengthThree) {
        this.concreteStrengthThree = concreteStrengthThree;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
}
