package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;

// 标段分数表
@Table(value = "tenderScores")
public class TenderScoreModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "scores")
    private Integer scores;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "securityGuid")
    private String securityGuid;
    @NotInsertColumn
    @Column(value = "createdAt")
    private Date createdAt;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段单位名称
    @JoinColumn(value = "organization", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderOrganization;  // 标段单位名称
    @JoinColumn(value = "name", type = SecurityModel.class, leftColumn = "securityGuid", rightColumn = "guid")
    private String securityName;  // 安全问题名称

    public TenderScoreModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
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

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getTenderOrganization() {
        return tenderOrganization;
    }

    public void setTenderOrganization(String tenderOrganization) {
        this.tenderOrganization = tenderOrganization;
    }

    public String getSecurityGuid() {
        return securityGuid;
    }

    public void setSecurityGuid(String securityGuid) {
        this.securityGuid = securityGuid;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TenderScoreModel{" +
                "guid='" + guid + '\'' +
                ", scores=" + scores +
                ", sortId=" + sortId +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", securityGuid='" + securityGuid + '\'' +
                ", createdAt=" + createdAt +
                ", tenderName='" + tenderName + '\'' +
                ", tenderOrganization='" + tenderOrganization + '\'' +
                ", securityName='" + securityName + '\'' +
                '}';
    }
}
