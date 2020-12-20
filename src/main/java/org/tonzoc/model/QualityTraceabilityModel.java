package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.sql.Date;

// 质量追溯
@Table("qualityTraceabilitys")
public class QualityTraceabilityModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "currentDate")
    private Date currentDate;  // 时间
    @Column(value = "operator")
    private String operator; // 操作人
    @Column(value = "qualityType")
    private String qualityType;  // 质量类型，原材料、半成品、实体工程
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "subTypeGuid")
    private String subTypeGuid;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段
    @JoinColumn(value = "name", type = SubTypeModel.class, leftColumn = "subTypeGuid", rightColumn = "guid")
    private String subTypeName;  // 文件类型

    public QualityTraceabilityModel() {
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

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getQualityType() {
        return qualityType;
    }

    public void setQualityType(String qualityType) {
        this.qualityType = qualityType;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getSubTypeGuid() {
        return subTypeGuid;
    }

    public void setSubTypeGuid(String subTypeGuid) {
        this.subTypeGuid = subTypeGuid;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }
}
