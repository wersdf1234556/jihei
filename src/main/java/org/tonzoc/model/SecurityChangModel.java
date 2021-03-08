package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

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
    private String tenderGuid; // 整改创建人
    @Column(value = "currentTenderGuid")
    private String currentTenderGuid;  // 当前审核人guid
    @Column(value = "approvalTime")
    private String approvalTime; // 审核时间
    @Column(value = "status")
    private String status; // 当前审批状态 unSubmit 未提交 submitted 已提交 finish 已审批
    @Column(value = "sortId")
    private Integer sortId;

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

    @Override
    public String toString() {
        return "SecurityChangModel{" +
                "guid='" + guid + '\'' +
                ", securityGuid='" + securityGuid + '\'' +
                ", chang='" + chang + '\'' +
                ", changTime='" + changTime + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", currentTenderGuid='" + currentTenderGuid + '\'' +
                ", approvalTime='" + approvalTime + '\'' +
                ", status='" + status + '\'' +
                ", sortId=" + sortId +
                '}';
    }
}
