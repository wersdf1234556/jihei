package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 梁组人
@Table("beamPersonGroups")
public class BeamPersonGroupModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "personGuid")
    private String personGuid;
    @Column(value = "personTypeGuid")
    private String personTypeGuid;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "beamGroupGuid")
    private String beamGroupGuid;

    @JoinColumn(value = "name", type = BeamGroupModel.class, leftColumn = "beamGroupGuid", rightColumn = "guid")
    private String beamGroupName;
    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "personGuid", rightColumn = "guid")
    private String personName;
    @JoinColumn(value = "idCard", type = PersonModel.class, leftColumn = "personGuid", rightColumn = "guid")
    private String personIdCard;
    @JoinColumn(value = "name", type = PersonTypeModel.class, leftColumn = "personTypeGuid", rightColumn = "guid")
    private String personTypeName;

    public BeamPersonGroupModel() {
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

    public String getBeamGroupGuid() {
        return beamGroupGuid;
    }

    public void setBeamGroupGuid(String beamGroupGuid) {
        this.beamGroupGuid = beamGroupGuid;
    }

    public String getBeamGroupName() {
        return beamGroupName;
    }

    public void setBeamGroupName(String beamGroupName) {
        this.beamGroupName = beamGroupName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonIdCard() {
        return personIdCard;
    }

    public void setPersonIdCard(String personIdCard) {
        this.personIdCard = personIdCard;
    }

    public String getPersonTypeName() {
        return personTypeName;
    }

    public void setPersonTypeName(String personTypeName) {
        this.personTypeName = personTypeName;
    }
}
