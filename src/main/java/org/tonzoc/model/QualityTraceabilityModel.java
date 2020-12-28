package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;

// 质量追溯
@Table("qualityTraceabilitys")
public class QualityTraceabilityModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "currentTime")
    private Date currentTime;  // 时间
    private String currentDate;
    @Column(value = "operator")
    private String operator; // 操作人
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "subTypeGuid")
    private String subTypeGuid;
    @Column(value = "typeId")
    private Integer typeId;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段名称
    @JoinColumn(value = "name", type = SubTypeModel.class, leftColumn = "subTypeGuid", rightColumn = "guid")
    private String subTypeName;  // 附属文件名称
    @JoinColumn(value = "name", type = TypeModel.class, leftColumn = "typeId", rightColumn = "id")
    private String typeName;  // 文件名称


    public QualityTraceabilityModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
