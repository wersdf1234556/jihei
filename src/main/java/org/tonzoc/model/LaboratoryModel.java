package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table("laboratorys")
public class LaboratoryModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "qualifiedRate")
    private Integer qualifiedRate;  // 合格率
    @Column(value = "companyName")
    private String companyName; // 单位名称
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "tenderType")
    private String tenderType;  // 标段类型，A标、B标、S标
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "subTypeGuid")
    private String subTypeGuid;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段
    @JoinColumn(value = "name", type = SubTypeModel.class, leftColumn = "subTypeGuid", rightColumn = "guid")
    private String subTypeName;  // 文件类型

    public LaboratoryModel() {
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

    public Integer getQualifiedRate() {
        return qualifiedRate;
    }

    public void setQualifiedRate(Integer qualifiedRate) {
        this.qualifiedRate = qualifiedRate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTenderType() {
        return tenderType;
    }

    public void setTenderType(String tenderType) {
        this.tenderType = tenderType;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
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

    public String getSubTypeGuid() {
        return subTypeGuid;
    }

    public void setSubTypeGuid(String subTypeGuid) {
        this.subTypeGuid = subTypeGuid;
    }

    public String getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }
}
