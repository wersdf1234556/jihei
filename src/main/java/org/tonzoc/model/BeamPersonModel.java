package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 梁人表
@Table(value = "beamPersons")
public class BeamPersonModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "beamGuid")
    private String beamGuid;
    @Column(value = "personGuid")
    private String personGuid;
    @Column(value = "personTypeGuid")
    private String personTypeGuid;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "attTime")
    private String attTime;
    @Column(value = "operator")
    private String operator;
    @Column(value = "tenderGuid")
    private String tenderGuid;

    // @JoinColumn(value = "", type = BeamModel.class, leftColumn = "personModel", rightColumn = "guid")
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;
    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "personGuid", rightColumn = "guid")
    private String personName;
    @JoinColumn(value = "name", type = PersonTypeModel.class, leftColumn = "personTypeGuid", rightColumn = "guid")
    private String personTypeName;

    public BeamPersonModel() {
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

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
    }

    public String getPersonTypeGuid() {
        return personTypeGuid;
    }

    public void setPersonTypeGuid(String personTypeGuid) {
        this.personTypeGuid = personTypeGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonTypeName() {
        return personTypeName;
    }

    public void setPersonTypeName(String personTypeName) {
        this.personTypeName = personTypeName;
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
