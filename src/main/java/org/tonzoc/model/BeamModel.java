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

    @Override
    public String toString() {
        return "BeamModel{" +
                "guid='" + guid + '\'' +
                ", beamPedestalGuid='" + beamPedestalGuid + '\'' +
                ", beamPrefabricationGuid='" + beamPrefabricationGuid + '\'' +
                ", concreteStrengthOne=" + concreteStrengthOne +
                ", concreteStrengthTwo=" + concreteStrengthTwo +
                ", concreteStrengthThree=" + concreteStrengthThree +
                ", sortId=" + sortId +
                ", beamPedestalName='" + beamPedestalName + '\'' +
                ", beamPrefabricationName='" + beamPrefabricationName + '\'' +
                '}';
    }
}
