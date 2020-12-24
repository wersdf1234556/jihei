package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "advertisingVideos")
public class AdvertisingVideoModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "title")
    private String title;
    @Column(value = "ImageGuid")
    private String ImageGuid;
    @Column(value = "date")
    private String date;
    @Column(value = "videoGuid")
    private String videoGuid;
    @JoinColumn(value = "url", type = AttachmentModel.class, leftColumn = "ImageGuid", rightColumn = "guid")
    private String ImageUrl; //图片url
    @JoinColumn(value = "url", type = AttachmentModel.class, leftColumn = "videoGuid", rightColumn = "guid")
    private String videoUrl; //视频url，自维护

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageGuid() {
        return ImageGuid;
    }

    public void setImageGuid(String imageGuid) {
        ImageGuid = imageGuid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVideoGuid() {
        return videoGuid;
    }

    public void setVideoGuid(String videoGuid) {
        this.videoGuid = videoGuid;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
