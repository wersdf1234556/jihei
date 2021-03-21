package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;

@Table(value = "attendances")
public class AttendanceModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "personGuid")
    private String personGuid;        //唯一识别字段
    @Column(value = "createdAt")  //创建时间
    @NotInsertColumn
    private Date createdAt;
    @Column(value = "address")
    private String address;  //登录地点
    @JoinColumn(value = "tenderGuid", type = PersonModel.class, leftColumn = "personGuid", rightColumn = "guid")
    private String tenderGuid;
    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "personGuid", rightColumn = "guid")
    private String personName;
    @JoinColumn(value = "idCard", type = PersonModel.class, leftColumn = "personGuid", rightColumn = "guid")
    private String idCard;
    @Column(value = "temperature")
    private String temperature;
    @Column(value = "lng")
    private String lng;
    @Column(value = "lat")
    private String lat;
    @Column(value = "takeTempPerson")
    private String takeTempPerson;
    @Column(value = "status")
    private Integer status;  //体温是否异常
    @Column(value = "remarks")
    private String remarks;
    @Column(value = "attTime")
    private String attTime; //打卡时间
    @Column(value = "inOutStatus")
    private Integer inOutStatus;//0：进  1：出
    @Column(value = "sign")
    private Integer sign;//0：闸机   1：手机端

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getTakeTempPerson() {
        return takeTempPerson;
    }

    public void setTakeTempPerson(String takeTempPerson) {
        this.takeTempPerson = takeTempPerson;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAttTime() {
        return attTime;
    }

    public void setAttTime(String attTime) {
        this.attTime = attTime;
    }

    public Integer getInOutStatus() {
        return inOutStatus;
    }

    public void setInOutStatus(Integer inOutStatus) {
        this.inOutStatus = inOutStatus;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "AttendanceModel{" +
                "guid='" + guid + '\'' +
                ", personGuid='" + personGuid + '\'' +
                ", createdAt=" + createdAt +
                ", address='" + address + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", personName='" + personName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", temperature='" + temperature + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", takeTempPerson='" + takeTempPerson + '\'' +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                ", attTime='" + attTime + '\'' +
                ", inOutStatus=" + inOutStatus +
                ", sign=" + sign +
                '}';
    }
}
