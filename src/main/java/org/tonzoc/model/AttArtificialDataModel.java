package org.tonzoc.model;

import org.tonzoc.annotation.*;
//人员考勤假数据
@Table(value = "attArtificialDatas")
public class AttArtificialDataModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "tenderGuid")
    private String tenderGuid; //标段
    @Column(value = "personTypeGuid")
    private String personTypeGuid; //类型
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName; //标段
    @JoinColumn(value = "name", type = PersonTypeModel.class, leftColumn = "personTypeGuid", rightColumn = "guid")
    private String typeName; //类型
    @Column(value = "personNum")
    private Integer personNum;  //人员数量
    @Column(value = "attNum")
    private Integer attNum; //考勤数量

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getPersonTypeGuid() {
        return personTypeGuid;
    }

    public void setPersonTypeGuid(String personTypeGuid) {
        this.personTypeGuid = personTypeGuid;
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

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public Integer getAttNum() {
        return attNum;
    }

    public void setAttNum(Integer attNum) {
        this.attNum = attNum;
    }
}
