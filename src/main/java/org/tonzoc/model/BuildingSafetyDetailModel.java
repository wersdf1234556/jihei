package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

//建安费表
@Table("buildingSafetyDetails")
public class BuildingSafetyDetailModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "safetyGuid")
    private String safetyGuid;
    @JoinColumn(value = "name", type = BuildingSafetyModel.class, leftColumn = "safetyGuid", rightColumn = "guid")
    private String safetyName; // 名称
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName; //标段
    @Column(value = "date")
    private String date;
    @Column(value = "balance")
    private BigDecimal balance;
    @Column(value = "createdAt")
    @NotInsertColumn
    private Date createdAt;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getSafetyGuid() {
        return safetyGuid;
    }

    public void setSafetyGuid(String safetyGuid) {
        this.safetyGuid = safetyGuid;
    }

    public String getSafetyName() {
        return safetyName;
    }

    public void setSafetyName(String safetyName) {
        this.safetyName = safetyName;
    }
}
