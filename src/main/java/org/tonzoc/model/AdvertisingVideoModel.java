package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;

// 宣传片列表
@Table(value = "advertisingVideos")
public class AdvertisingVideoModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "currentTime")
    private Date currentTime;
    private String currentDate;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "imgAttachmentGuid")
    private String imgAttachmentGuid;
    @Column(value = "videoAttachmentGuid")
    private String videoAttachmentGuid;
    @Column(value = "profile")
    private String profile; // 宣传片简介

    @JoinColumn(value = "name", type = AttachmentModel.class, leftColumn = "imgAttachmentGuid", rightColumn = "guid")
    private String imgName; // 图片的名称
    @JoinColumn(value = "name", type = AttachmentModel.class, leftColumn = "videoAttachmentGuid", rightColumn = "guid")
    private String videoName; // 视频名称，自维护

    public AdvertisingVideoModel() {
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

    public String getImgAttachmentGuid() {
        return imgAttachmentGuid;
    }

    public void setImgAttachmentGuid(String imgAttachmentGuid) {
        this.imgAttachmentGuid = imgAttachmentGuid;
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

    public String getVideoAttachmentGuid() {
        return videoAttachmentGuid;
    }

    public void setVideoAttachmentGuid(String videoAttachmentGuid) {
        this.videoAttachmentGuid = videoAttachmentGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    @Override
    public String toString() {
        return "AdvertisingVideoModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", currentTime=" + currentTime +
                ", currentDate='" + currentDate + '\'' +
                ", sortId=" + sortId +
                ", imgAttachmentGuid='" + imgAttachmentGuid + '\'' +
                ", videoAttachmentGuid='" + videoAttachmentGuid + '\'' +
                ", profile='" + profile + '\'' +
                ", imgName='" + imgName + '\'' +
                ", videoName='" + videoName + '\'' +
                '}';
    }
}