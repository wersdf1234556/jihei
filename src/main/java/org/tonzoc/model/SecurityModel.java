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
    @Column(value = "createPersonName")
    private String createPersonName; // 下单人名称
    @Column(value = "changTenderGuid")
    private String changTenderGuid; // 整改标段
    @Column(value = "describe")
    private String describe; // 问题描述
    @Column(value = "securityRuleGuid")
    private String securityRuleGuid; // 分数规则
    @Column(value = "defaultScore")
    private Integer defaultScore; // 默认分数
    @Column(value = "limitTime")
    private String limitTime; // 截止时间
    @Column(value = "ccPersonGuid")
    private String ccPersonGuid; // 抄送人的guid
    @Column(value = "approvalTenderGuid")
    private String approvalTenderGuid; // 审批标段
    @Column(value = "approvalTime")
    private String approvalTime; // 审批时间
    @Column(value = "approvalScore")
    private Integer approvalScore; // 最终分数
    @Column(value = "status")
    private String status;  // 当前审批状态 submitted 已提交 finish 已审批
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "accounType")
    private String accounType;
    @NotInsertColumn
    @Column(value = "createdAt")
    private Date createdAt;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "changTenderGuid", rightColumn = "guid")
    private String changTenderName;  // 整改标段名称
    @JoinColumn(value = "name", type = SecurityRuleModel.class, leftColumn = "securityRuleGuid", rightColumn = "guid")
    private String securityRuleName;  // 分数规则
    @JoinColumn(value = "defaultScore", type = SecurityRuleModel.class, leftColumn = "securityRuleGuid", rightColumn = "guid")
    private Integer SecurityRuleDefaultScore;  // 默认分数
    @JoinColumn(value = "rules", type = SecurityRuleModel.class, leftColumn = "securityRuleGuid", rightColumn = "guid")
    private String securityRule;  // 分数规则说明
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "approvalTenderGuid", rightColumn = "guid")
    private String approvalTenderName;  // 审批标段名称

    public SecurityModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getChangTenderGuid() {
        return changTenderGuid;
    }

    public void setChangTenderGuid(String changTenderGuid) {
        this.changTenderGuid = changTenderGuid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getSecurityRuleGuid() {
        return securityRuleGuid;
    }

    public void setSecurityRuleGuid(String securityRuleGuid) {
        this.securityRuleGuid = securityRuleGuid;
    }

    public Integer getDefaultScore() {
        return defaultScore;
    }

    public void setDefaultScore(Integer defaultScore) {
        this.defaultScore = defaultScore;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public String getCcPersonGuid() {
        return ccPersonGuid;
    }

    public void setCcPersonGuid(String ccPersonGuid) {
        this.ccPersonGuid = ccPersonGuid;
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

    public Integer getApprovalScore() {
        return approvalScore;
    }

    public void setApprovalScore(Integer approvalScore) {
        this.approvalScore = approvalScore;
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

    public String getChangTenderName() {
        return changTenderName;
    }

    public void setChangTenderName(String changTenderName) {
        this.changTenderName = changTenderName;
    }

    public String getSecurityRuleName() {
        return securityRuleName;
    }

    public void setSecurityRuleName(String securityRuleName) {
        this.securityRuleName = securityRuleName;
    }

    public Integer getSecurityRuleDefaultScore() {
        return SecurityRuleDefaultScore;
    }

    public void setSecurityRuleDefaultScore(Integer securityRuleDefaultScore) {
        SecurityRuleDefaultScore = securityRuleDefaultScore;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public String getSecurityRule() {
        return securityRule;
    }

    public void setSecurityRule(String securityRule) {
        this.securityRule = securityRule;
    }

    public String getApprovalTenderName() {
        return approvalTenderName;
    }

    public void setApprovalTenderName(String approvalTenderName) {
        this.approvalTenderName = approvalTenderName;
    }

    public String getAccounType() {
        return accounType;
    }

    public void setAccounType(String accounType) {
        this.accounType = accounType;
    }

    @Override
    public String toString() {
        return "SecurityModel{" +
                "guid='" + guid + '\'' +
                ", createPersonName='" + createPersonName + '\'' +
                ", changTenderGuid='" + changTenderGuid + '\'' +
                ", describe='" + describe + '\'' +
                ", securityRuleGuid='" + securityRuleGuid + '\'' +
                ", defaultScore=" + defaultScore +
                ", limitTime='" + limitTime + '\'' +
                ", ccPersonGuid='" + ccPersonGuid + '\'' +
                ", approvalTenderGuid='" + approvalTenderGuid + '\'' +
                ", approvalTime='" + approvalTime + '\'' +
                ", approvalScore=" + approvalScore +
                ", status='" + status + '\'' +
                ", sortId=" + sortId +
                ", accounType='" + accounType + '\'' +
                ", createdAt=" + createdAt +
                ", changTenderName='" + changTenderName + '\'' +
                ", securityRuleName='" + securityRuleName + '\'' +
                ", SecurityRuleDefaultScore=" + SecurityRuleDefaultScore +
                ", securityRule='" + securityRule + '\'' +
                ", approvalTenderName='" + approvalTenderName + '\'' +
                '}';
    }
}
