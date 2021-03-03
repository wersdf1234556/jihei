package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 安全表
@Table("securitys")
public class SecurityModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "documentGuid")
    private String documentGuid; // 明细表guid
    @Column(value = "tenderGuid")
    private String tenderGuid; // 标段表guid
    @Column(value = "securityRuleGuid")
    private String securityRuleGuid; // 分数规则表guid
    @Column(value = "createPersonGuid")
    private String createPersonGuid; // 创建人的guid
    @Column(value = "score")
    private Integer score; // 分数
    @Column(value = "imgAttachmentGuid")
    private String imgAttachmentGuid;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "status")
    private String status;
    @Column(value = "describe")
    private String describe; // 问题描述

    @JoinColumn(value = "name", type = DocumentModel.class, leftColumn = "documentGuid", rightColumn = "guid")
    private String documentName;  // 明细名称
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段名称
    @JoinColumn(value = "name", type = SecurityRuleModel.class, leftColumn = "securityRuleGuid", rightColumn = "guid")
    private String securityRuleName;  // 分数规则名称
    @JoinColumn(value = "rules", type = SecurityRuleModel.class, leftColumn = "securityRuleGuid", rightColumn = "guid")
    private String securityRule;  // 分数规则说明
    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "personGuid", rightColumn = "guid")
    private String personName;  // 人员名称
    @JoinColumn(value = "name", type = AttachmentModel.class, leftColumn = "imgAttachmentGuid", rightColumn = "guid")
    private String imgAttachmentName;  // 图片名称

    public SecurityModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDocumentGuid() {
        return documentGuid;
    }

    public void setDocumentGuid(String documentGuid) {
        this.documentGuid = documentGuid;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getImgAttachmentGuid() {
        return imgAttachmentGuid;
    }

    public void setImgAttachmentGuid(String imgAttachmentGuid) {
        this.imgAttachmentGuid = imgAttachmentGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getImgAttachmentName() {
        return imgAttachmentName;
    }

    public void setImgAttachmentName(String imgAttachmentName) {
        this.imgAttachmentName = imgAttachmentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "SecurityModel{" +
                "guid='" + guid + '\'' +
                ", documentGuid='" + documentGuid + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", securityRuleGuid='" + securityRuleGuid + '\'' +
                ", createPersonGuid='" + createPersonGuid + '\'' +
                ", score=" + score +
                ", imgAttachmentGuid='" + imgAttachmentGuid + '\'' +
                ", sortId=" + sortId +
                ", status='" + status + '\'' +
                ", describe='" + describe + '\'' +
                ", documentName='" + documentName + '\'' +
                ", tenderName='" + tenderName + '\'' +
                ", securityRuleName='" + securityRuleName + '\'' +
                ", securityRule='" + securityRule + '\'' +
                ", personName='" + personName + '\'' +
                ", imgAttachmentName='" + imgAttachmentName + '\'' +
                '}';
    }
}
