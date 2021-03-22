package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;

// 质量追溯
@Table("qualityTraceabilitys")
public class QualityTraceabilityModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "typeId")
    private Integer typeId;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "name")
    private String name;
    @Column(value = "currentTime")
    private Date currentTime;  // 时间
    private String currentDate;
    @Column(value = "operator")
    private String operator; // 操作人
    @Column(value = "parts")
    private String parts; // 部位
    @Column(value = "major")
    private String major; // 专业
    @Column(value = "qrcodeGuid")
    private String qrcodeGuid;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "status")
    private String status; // 当前审批状态 unSubmit 未提交 submitted 已提交 finish 已审批
    @Column(value = "currentTenderGuid")
    private String currentTenderGuid; // 当前审批标段
    @Column(value = "approvalTime")
    private String approvalTime; // 审批时间
    @Column(value = "subTypeGuid")
    private String subTypeGuid; // 类型
    @NotInsertColumn
    @Column(value = "createdAt")
    private Date createdAt;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段名称
    @JoinColumn(value = "name", type = TypeModel.class, leftColumn = "typeId", rightColumn = "id")
    private String typeName;  // 文件名称
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "currentTenderGuid", rightColumn = "guid")
    private String currentTenderName;  // 审批标段名称
    @JoinColumn(value = "name", type = SubTypeModel.class, leftColumn = "subTypeGuid", rightColumn = "guid")
    private String subTypeName;  // 类型名称

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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getQrcodeGuid() {
        return qrcodeGuid;
    }

    public void setQrcodeGuid(String qrcodeGuid) {
        this.qrcodeGuid = qrcodeGuid;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getApprovalTime() {
        return approvalTime;
    }

    public String getCurrentTenderGuid() {
        return currentTenderGuid;
    }

    public void setCurrentTenderGuid(String currentTenderGuid) {
        this.currentTenderGuid = currentTenderGuid;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getCurrentTenderName() {
        return currentTenderName;
    }

    public void setCurrentTenderName(String currentTenderName) {
        this.currentTenderName = currentTenderName;
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

    @Override
    public String toString() {
        return "QualityTraceabilityModel{" +
                "guid='" + guid + '\'' +
                ", typeId=" + typeId +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", name='" + name + '\'' +
                ", currentTime=" + currentTime +
                ", currentDate='" + currentDate + '\'' +
                ", operator='" + operator + '\'' +
                ", parts='" + parts + '\'' +
                ", major='" + major + '\'' +
                ", qrcodeGuid='" + qrcodeGuid + '\'' +
                ", sortId=" + sortId +
                ", status='" + status + '\'' +
                ", currentTenderGuid='" + currentTenderGuid + '\'' +
                ", approvalTime='" + approvalTime + '\'' +
                ", subTypeGuid='" + subTypeGuid + '\'' +
                ", createdAt=" + createdAt +
                ", tenderName='" + tenderName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", currentTenderName='" + currentTenderName + '\'' +
                ", subTypeName='" + subTypeName + '\'' +
                '}';
    }
}
