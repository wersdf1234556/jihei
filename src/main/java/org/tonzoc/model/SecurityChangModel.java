package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

import java.util.Date;

@Table(value = "securityChangs")
public class SecurityChangModel extends BaseModel{

    // @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "chang")
    private String chang; // 整改描述
    @Column(value = "changTime")
    private Date changTime; // 整改时间
    private String changDate;
    @Column(value = "createPersonGuid")
    private String createPersonGuid;  //整改创建人
    @Column(value = "tenderGuid")
    private String tenderGuid; // 标段
    @Column(value = "checkPersonGuid")
    private String checkPersonGuid; // 审核人
    @Column(value = "checkTime")
    private Date checkTime; // 审核时间
    private String checkDate;
    @Column(value = "status")
    private String status; // 状态
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "securityGuid")
    private String securityGuid;

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

    public Date getChangTime() {
        return changTime;
    }

    public void setChangTime(Date changTime) {
        this.changTime = changTime;
    }

    public String getChangDate() {
        return changDate;
    }

    public void setChangDate(String changDate) {
        this.changDate = changDate;
    }

    public String getCreatePersonGuid() {
        return createPersonGuid;
    }

    public void setCreatePersonGuid(String createPersonGuid) {
        this.createPersonGuid = createPersonGuid;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getCheckPersonGuid() {
        return checkPersonGuid;
    }

    public void setCheckPersonGuid(String checkPersonGuid) {
        this.checkPersonGuid = checkPersonGuid;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
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
                ", chang='" + chang + '\'' +
                ", changTime=" + changTime +
                ", changDate='" + changDate + '\'' +
                ", createPersonGuid='" + createPersonGuid + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", checkPersonGuid='" + checkPersonGuid + '\'' +
                ", checkTime=" + checkTime +
                ", checkDate='" + checkDate + '\'' +
                ", status='" + status + '\'' +
                ", sortId=" + sortId +
                ", securityGuid='" + securityGuid + '\'' +
                '}';
    }
}
