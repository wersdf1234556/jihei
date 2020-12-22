package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

import java.sql.Date;

public class MemorabiliaQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "eq", field = "currentTime")
    private Date currentTime;

    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    @Operator(value = "eq", field = "imgAttachmentGuid")
    private String imgAttachmentGuid;

    @Operator(value = "eq", field = "pdfAttachmentGuid")
    private String pdfAttachmentGuid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
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

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }
}
