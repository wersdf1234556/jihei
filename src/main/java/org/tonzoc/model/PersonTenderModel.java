package org.tonzoc.model;

import org.tonzoc.annotation.*;


// 人员绑定标段表
@Table(value = "personTenders")
public class PersonTenderModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "personGuid")
    private String personGuid;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "sortId")
    private Integer sortId;

    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "personGuid", rightColumn = "guid")
    private String personName;  // 人员名称
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段名称

    public PersonTenderModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    @Override
    public String toString() {
        return "PersonTenderModel{" +
                "guid='" + guid + '\'' +
                ", personGuid='" + personGuid + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", sortId=" + sortId +
                ", personName='" + personName + '\'' +
                ", tenderName='" + tenderName + '\'' +
                '}';
    }
}