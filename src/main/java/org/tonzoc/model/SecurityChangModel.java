package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;

@Table(value = "securityChangs")
public class SecurityChangModel extends BaseModel{

    // @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "securityGuid")
    private String securityGuid;
    @Column(value = "changTenderGuid")
    private String changTenderGuid; // 整改标段
    @Column(value = "chang")
    private String chang; // 整改描述
    @Column(value = "approvalTenderGuid")
    private String approvalTenderGuid; // 审批人标段
    @Column(value = "approvalTime")
    private String approvalTime; // 审核时间
    @Column(value = "status")
    private String status; // 当前审批状态 unSubmit 未提交 submitted 已提交 finish 已审批
    @Column(value = "sortId")
    private Integer sortId;
    @NotInsertColumn
    @Column(value = "createdAt")
    private Date createdAt;

    @JoinColumn(value = "describe", type = SecurityModel.class, leftColumn = "securityGuid", rightColumn = "guid")
    private String securityName;  // 问题名称
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "changTenderGuid", rightColumn = "guid")
    private String tenderName;  // 整改标段名称
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "approvalTenderGuid", rightColumn = "guid")
    private String approvalTenderName;  // 审批标段名称

    public SecurityChangModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getSecurityGuid() {
        return securityGuid;
    }

    public void setSecurityGuid(String securityGuid) {
        this.securityGuid = securityGuid;
    }

    public String getChangTenderGuid() {
        return changTenderGuid;
    }

    public void setChangTenderGuid(String changTenderGuid) {
        this.changTenderGuid = changTenderGuid;
    }

    public String getChang() {
        return chang;
    }

    public void setChang(String chang) {
        this.chang = chang;
    }

    public String getApprovalTenderGuid() {
        return approvalTenderGuid;
    }

    public void setApprovalTenderGuid(String approvalTenderGuid) {
        this.approvalTenderGuid = approvalTenderGuid;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getApprovalTenderName() {
        return approvalTenderName;
    }

    public void setApprovalTenderName(String approvalTenderName) {
        this.approvalTenderName = approvalTenderName;
    }

    @Override
    public String toString() {
        return "SecurityChangModel{" +
                "guid='" + guid + '\'' +
                ", securityGuid='" + securityGuid + '\'' +
                ", changTenderGuid='" + changTenderGuid + '\'' +
                ", chang='" + chang + '\'' +
                ", approvalTenderGuid='" + approvalTenderGuid + '\'' +
                ", approvalTime='" + approvalTime + '\'' +
                ", status='" + status + '\'' +
                ", sortId=" + sortId +
                ", createdAt=" + createdAt +
                ", securityName='" + securityName + '\'' +
                ", tenderName='" + tenderName + '\'' +
                ", approvalTenderName='" + approvalTenderName + '\'' +
                '}';
    }
}
