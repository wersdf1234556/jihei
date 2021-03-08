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
    @Column(value = "describe")
    private String describe; // 问题描述
    @Column(value = "score")
    private Integer score; // 分数
    @Column(value = "tenderGuid")
    private String tenderGuid; // 标段表guid
    @Column(value = "securityRuleGuid")
    private String securityRuleGuid; // 分数规则表guid
    @Column(value = "createPersonGuid")
    private String createPersonGuid; // 创建人的guid
    @Column(value = "ccPersonGuid")
    private String ccPersonGuid; // 抄送人的guid
    @Column(value = "createTime")
    private Date createTime;  // 创建时间
    private String createDate;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "status")
    private String status; // 状态 0是未处理，1是已处理

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段名称
    @JoinColumn(value = "name", type = SecurityRuleModel.class, leftColumn = "securityRuleGuid", rightColumn = "guid")
    private String securityRuleName;  // 分数规则名称
    @JoinColumn(value = "rules", type = SecurityRuleModel.class, leftColumn = "securityRuleGuid", rightColumn = "guid")
    private String securityRule;  // 分数规则说明
    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "createPersonGuid", rightColumn = "guid")
    private String createPersonName;  // 创建人员名称
    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "ccPersonGuid", rightColumn = "guid")
    private String ccPersonName;  // 创建人员名称


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

    public String getCreatePersonGuid() {
        return createPersonGuid;
    }

    public void setCreatePersonGuid(String createPersonGuid) {
        this.createPersonGuid = createPersonGuid;
    }

    public String getCcPersonGuid() {
        return ccPersonGuid;
    }

    public void setCcPersonGuid(String ccPersonGuid) {
        this.ccPersonGuid = ccPersonGuid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public String getCcPersonName() {
        return ccPersonName;
    }

    public void setCcPersonName(String ccPersonName) {
        this.ccPersonName = ccPersonName;
    }

    @Override
    public String toString() {
        return "SecurityModel{" +
                "guid='" + guid + '\'' +
                ", describe='" + describe + '\'' +
                ", score=" + score +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", securityRuleGuid='" + securityRuleGuid + '\'' +
                ", createPersonGuid='" + createPersonGuid + '\'' +
                ", ccPersonGuid='" + ccPersonGuid + '\'' +
                ", createTime=" + createTime +
                ", createDate='" + createDate + '\'' +
                ", sortId=" + sortId +
                ", status='" + status + '\'' +
                ", tenderName='" + tenderName + '\'' +
                ", securityRuleName='" + securityRuleName + '\'' +
                ", securityRule='" + securityRule + '\'' +
                ", createPersonName='" + createPersonName + '\'' +
                ", ccPersonName='" + ccPersonName + '\'' +
                '}';
    }
}
