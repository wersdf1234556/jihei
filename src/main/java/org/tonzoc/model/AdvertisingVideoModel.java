package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;

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

    @JoinColumn(value = "url", type = AttachmentModel.class, leftColumn = "imgAttachmentGuid", rightColumn = "guid")
    private String imgUrl; //图片的url
    @JoinColumn(value = "url", type = AttachmentModel.class, leftColumn = "videoAttachmentGuid", rightColumn = "guid")
    private String videoUrl; //视频url，自维护

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
