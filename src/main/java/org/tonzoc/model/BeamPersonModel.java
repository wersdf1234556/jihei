package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 梁人表
@Table(value = "beamPersons")
public class BeamPersonModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "beamOrderGuid")
    private String beamOrderGuid;
    @Column(value = "personGuid")
    private String personGuid;
    @Column(value = "personTypeGuid")
    private String personTypeGuid;
    @Column(value = "sortId")
    private Integer sortId;

    @JoinColumn(value = "orders", type = BeamOrderModel.class, leftColumn = "beamOrderGuid", rightColumn = "guid")
    private String orders;
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

    public String getBeamOrderGuid() {
        return beamOrderGuid;
    }

    public void setBeamOrderGuid(String beamOrderGuid) {
        this.beamOrderGuid = beamOrderGuid;
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
}
