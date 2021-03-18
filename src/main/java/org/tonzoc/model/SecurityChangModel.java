package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "securityChangs")
public class SecurityChangModel extends BaseModel{

    // @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "securityGuid")
    private String securityGuid;
    @Column(value = "chang")
    private String chang; // 整改描述
    @Column(value = "changTime")
    private String changTime; // 整改时间
    @Column(value = "tenderGuid")
    private String tenderGuid; // 整改创建标段
    @Column(value = "createPersonName")
    private String createPersonName; // 创建人名称
    @Column(value = "approvalPersonName")
    private String approvalPersonName; // 审批人名称
    @Column(value = "currentTenderGuid")
    private String currentTenderGuid;  // 当前审核标段guid
    @Column(value = "approvalTime")
    private String approvalTime; // 审核时间
    @Column(value = "status")
    private String status; // 当前审批状态 unSubmit 未提交 submitted 已提交 finish 已审批
    @Column(value = "sortId")
    private Integer sortId;

    @JoinColumn(value = "describe", type = SecurityModel.class, leftColumn = "securityGuid", rightColumn = "guid")
    private String securityName;  // 问题名称
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段名称
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "currentTenderGuid", rightColumn = "guid")
    private String currentTenderName;  // 当前审核标段

    public SecurityChangModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getChang() {
        return chang;
    }

    public void setChang(String chang) {
        this.chang = chang;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getChangTime() {
        return changTime;
    }

    public void setChangTime(String changTime) {
        this.changTime = changTime;
    }

    public String getCurrentTenderGuid() {
        return currentTenderGuid;
    }

    public void setCurrentTenderGuid(String currentTenderGuid) {
        this.currentTenderGuid = currentTenderGuid;
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

    public String getSecurityGuid() {
        return securityGuid;
    }

    public void setSecurityGuid(String securityGuid) {
        this.securityGuid = securityGuid;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public String getApprovalPersonName() {
        return approvalPersonName;
    }

    public void setApprovalPersonName(String approvalPersonName) {
        this.approvalPersonName = approvalPersonName;
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

    public String getCurrentTenderName() {
        return currentTenderName;
    }

    public void setCurrentTenderName(String currentTenderName) {
        this.currentTenderName = currentTenderName;
    }

    @Override
    public String toString() {
        return "SecurityChangModel{" +
                "guid='" + guid + '\'' +
                ", securityGuid='" + securityGuid + '\'' +
                ", chang='" + chang + '\'' +
                ", changTime='" + changTime + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", createPersonName='" + createPersonName + '\'' +
                ", approvalPersonName='" + approvalPersonName + '\'' +
                ", currentTenderGuid='" + currentTenderGuid + '\'' +
                ", approvalTime='" + approvalTime + '\'' +
                ", status='" + status + '\'' +
                ", sortId=" + sortId +
                ", securityName='" + securityName + '\'' +
                ", tenderName='" + tenderName + '\'' +
                ", currentTenderName='" + currentTenderName + '\'' +
                '}';
    }
}
