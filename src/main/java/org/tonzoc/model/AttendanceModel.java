package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;

@Table(value = "attendances")
public class AttendanceModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "idCard")
    private String idCard;        //唯一识别字段
    @Column(value = "createdAt")  //打卡时间
    @NotInsertColumn
    private Date createdAt;
    @Column(value = "address")
    private String address;  //登录地点
    @JoinColumn(value = "tenderGuid", type = PersonModel.class, leftColumn = "idCard", rightColumn = "idCard")
    private String tenderGuid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    @Override
    public String toString() {
        return "AttendanceModel{" +
                "guid='" + guid + '\'' +
                ", idCard='" + idCard + '\'' +
                ", createdAt=" + createdAt +
                ", address='" + address + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                '}';
    }
}
