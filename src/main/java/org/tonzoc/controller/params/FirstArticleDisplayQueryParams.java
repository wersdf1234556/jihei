package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class FirstArticleDisplayQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "like", field = "name")
    private String name;

    @Operator(value = "eq", field = "currentTime")
    private String currentDate;

    @Operator(value = "eq", field = "imgAttachmentGuid")
    private String imgAttachmentGuid;

    @Operator(value = "eq", field = "videoAttachmentGuid")
    private String videoAttachmentGuid;

    @Operator(value = "eq", field = "profile")
    private String profile;

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

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getImgAttachmentGuid() {
        return imgAttachmentGuid;
    }

    public String getVideoAttachmentGuid() {
        return videoAttachmentGuid;
    }

    public void setVideoAttachmentGuid(String videoAttachmentGuid) {
        this.videoAttachmentGuid = videoAttachmentGuid;
    }

    public void setImgAttachmentGuid(String imgAttachmentGuid) {
        this.imgAttachmentGuid = imgAttachmentGuid;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
