package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;

// 安全表
@Table("securitys")
public class SecurityModel extends BaseModel {

    // @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "tenderGuid")
    private String tenderGuid; // 标段表guid
    @Column(value = "describe")
    private String describe; // 问题描述
    @Column(value = "securityRuleGuid")
    private String securityRuleGuid; // 分数规则表guid
    @Column(value = "score")
    private Integer score; // 分数
    @Column(value = "createTime")
    private String createTime; // 创建时间
    @Column(value = "createPersonName")
    private String createPersonName; // 创建人名称
    @Column(value = "ccPersonGuid")
    private String ccPersonGuid; // 抄送人的guid
    @Column(value = "status")
    private String status; // 当前审批状态 unSubmit 未提交 submitted 已提交 finish 已审批
    @Column(value = "approvalTime")
    private String approvalTime; // 审批时间
    @Column(value = "currentTenderGuid")
    private String currentTenderGuid; // 当前审批标段
    @Column(value = "sortId")
    private Integer sortId;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段名称
    @JoinColumn(value = "name", type = SecurityRuleModel.class, leftColumn = "securityRuleGuid", rightColumn = "guid")
    private String securityRuleName;  // 分数规则名称
    @JoinColumn(value = "rules", type = SecurityRuleModel.class, leftColumn = "securityRuleGuid", rightColumn = "guid")
    private String securityRule;  // 分数规则说明
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "currentTenderGuid", rightColumn = "guid")
    private String currentTenderName;  // 当前审批标段名称
    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "ccPersonGuid", rightColumn = "guid")
    private String ccPersonName;  // 抄送人员名称

    public SecurityModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getSecurityRuleGuid() {
        return securityRuleGuid;
    }

    public void setSecurityRuleGuid(String securityRuleGuid) {
        this.securityRuleGuid = securityRuleGuid;
    }

    public String getCcPersonGuid() {
        return ccPersonGuid;
    }

    public void setCcPersonGuid(String ccPersonGuid) {
        this.ccPersonGuid = ccPersonGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getSecurityRuleName() {
        return securityRuleName;
    }

    public void setSecurityRuleName(String securityRuleName) {
        this.securityRuleName = securityRuleName;
    }

    public String getSecurityRule() {
        return securityRule;
    }

    public void setSecurityRule(String securityRule) {
        this.securityRule = securityRule;
    }

    public String getCcPersonName() {
        return ccPersonName;
    }

    public void setCcPersonName(String ccPersonName) {
        this.ccPersonName = ccPersonName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getCurrentTenderGuid() {
        return currentTenderGuid;
    }

    public void setCurrentTenderGuid(String currentTenderGuid) {
        this.currentTenderGuid = currentTenderGuid;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public String getCurrentTenderName() {
        return currentTenderName;
    }

    public void setCurrentTenderName(String currentTenderName) {
        this.currentTenderName = currentTenderName;
    }


    @Override
    public String toString() {
        return "SecurityModel{" +
                "guid='" + guid + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", describe='" + describe + '\'' +
                ", securityRuleGuid='" + securityRuleGuid + '\'' +
                ", score=" + score +
                ", createTime='" + createTime + '\'' +
                ", createPersonName='" + createPersonName + '\'' +
                ", ccPersonGuid='" + ccPersonGuid + '\'' +
                ", status='" + status + '\'' +
                ", approvalTime='" + approvalTime + '\'' +
                ", currentTenderGuid='" + currentTenderGuid + '\'' +
                ", sortId=" + sortId +
                ", tenderName='" + tenderName + '\'' +
                ", securityRuleName='" + securityRuleName + '\'' +
                ", securityRule='" + securityRule + '\'' +
                ", currentTenderName='" + currentTenderName + '\'' +
                ", ccPersonName='" + ccPersonName + '\'' +
                '}';
    }
}
