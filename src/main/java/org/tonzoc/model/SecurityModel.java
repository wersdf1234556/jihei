package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;

// 安全表
@Table("securitys")
public class SecurityModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "currentTime")
    private Date currentTime;
    private String currentDate;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "personGuid")
    private String personGuid;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "imgAttachmentGuid")
    private String imgAttachmentGuid;
    @Column(value = "pdfAttachmentGuid")
    private String pdfAttachmentGuid;
    @Column(value = "state")
    private String state;

    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "personGuid", rightColumn = "guid")
    private String personName;  // 人员名称
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tednerName;  // 标段名称
    @JoinColumn(value = "name", type = AttachmentModel.class, leftColumn = "imgAttachmentGuid", rightColumn = "guid")
    private String imgName;  // 图片名称
    @JoinColumn(value = "name", type = AttachmentModel.class, leftColumn = "pdfAttachmentGuid", rightColumn = "guid")
    private String pdfName;  // pdf名称

    public SecurityModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getImgAttachmentGuid() {
        return imgAttachmentGuid;
    }

    public void setImgAttachmentGuid(String imgAttachmentGuid) {
        this.imgAttachmentGuid = imgAttachmentGuid;
    }

    public String getPdfAttachmentGuid() {
        return pdfAttachmentGuid;
    }

    public void setPdfAttachmentGuid(String pdfAttachmentGuid) {
        this.pdfAttachmentGuid = pdfAttachmentGuid;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getTednerName() {
        return tednerName;
    }

    public void setTednerName(String tednerName) {
        this.tednerName = tednerName;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    @Override
    public String toString() {
        return "SecurityModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", currentTime=" + currentTime +
                ", currentDate='" + currentDate + '\'' +
                ", sortId=" + sortId +
                ", personGuid='" + personGuid + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", imgAttachmentGuid='" + imgAttachmentGuid + '\'' +
                ", pdfAttachmentGuid='" + pdfAttachmentGuid + '\'' +
                ", state='" + state + '\'' +
                ", personName='" + personName + '\'' +
                ", tednerName='" + tednerName + '\'' +
                ", imgName='" + imgName + '\'' +
                ", pdfName='" + pdfName + '\'' +
                '}';
    }
}
