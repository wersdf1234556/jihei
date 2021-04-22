package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 梁的基础表
@Table("beams")
public class BeamModel extends BaseModel{

    @PrimaryKey
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

    @JoinColumn(value = "name", type = BeamPedestalModel.class, leftColumn = "beamPedestalGuid", rightColumn = "guid")
    private String beamPedestalName;
    @JoinColumn(value = "status", type = BeamPedestalModel.class, leftColumn = "beamPedestalGuid", rightColumn = "guid")
    private String beamPedestalStatus;

    @JoinColumn(value = "name", type = BeamPrefabricationModel.class, leftColumn = "beamPrefabricationGuid", rightColumn = "guid")
    private String beamPrefabricationName;
    @JoinColumn(value = "status", type = BeamPrefabricationModel.class, leftColumn = "beamPrefabricationGuid", rightColumn = "guid")
    private String beamPrefabricationStatus;
    @JoinColumn(value = "leftAndRight", type = BeamPrefabricationModel.class, leftColumn = "beamPrefabricationGuid", rightColumn = "guid")
    private String leftAndRight;
    @JoinColumn(value = "span", type = BeamPrefabricationModel.class, leftColumn = "beamPrefabricationGuid", rightColumn = "guid")
    private String span;
    @JoinColumn(value = "prefabricationNum", type = BeamPrefabricationModel.class, leftColumn = "beamPrefabricationGuid", rightColumn = "guid")
    private String prefabricationNum;
    @JoinColumn(value = "concreteStrengthOne", type = BeamPrefabricationModel.class, leftColumn = "beamPrefabricationGuid", rightColumn = "guid")
    private String concreteStrengthOne;
    @JoinColumn(value = "concreteStrengthTwo", type = BeamPrefabricationModel.class, leftColumn = "beamPrefabricationGuid", rightColumn = "guid")
    private String concreteStrengthTwo;
    @JoinColumn(value = "concreteStrengthThree", type = BeamPrefabricationModel.class, leftColumn = "beamPrefabricationGuid", rightColumn = "guid")
    private String concreteStrengthThree;
    @JoinColumn(value = "remarks", type = BeamPrefabricationModel.class, leftColumn = "beamPrefabricationGuid", rightColumn = "guid")
    private String remarks;

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

    public String getConcreteStrengthOne() {
        return concreteStrengthOne;
    }

    public void setConcreteStrengthOne(String concreteStrengthOne) {
        this.concreteStrengthOne = concreteStrengthOne;
    }

    public String getConcreteStrengthTwo() {
        return concreteStrengthTwo;
    }

    public void setConcreteStrengthTwo(String concreteStrengthTwo) {
        this.concreteStrengthTwo = concreteStrengthTwo;
    }

    public String getConcreteStrengthThree() {
        return concreteStrengthThree;
    }

    public void setConcreteStrengthThree(String concreteStrengthThree) {
        this.concreteStrengthThree = concreteStrengthThree;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLeftAndRight() {
        return leftAndRight;
    }

    public void setLeftAndRight(String leftAndRight) {
        this.leftAndRight = leftAndRight;
    }

    public String getSpan() {
        return span;
    }

    public void setSpan(String span) {
        this.span = span;
    }

    public String getPrefabricationNum() {
        return prefabricationNum;
    }

    public void setPrefabricationNum(String prefabricationNum) {
        this.prefabricationNum = prefabricationNum;
    }
}
