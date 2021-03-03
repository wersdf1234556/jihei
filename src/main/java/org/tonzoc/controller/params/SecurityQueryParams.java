package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class SecurityQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "eq", field = "currentTime")
    private String currentDate;

    @Operator(value = "eq", field = "personGuid")
    private String personGuid;

    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;

    @Operator(value = "eq", field = "imgAttachmentGuid")
    private String imgAttachmentGuid;

    @Operator(value = "eq", field = "pdfAttachmentGuid")
    private String pdfAttachmentGuid;

    @Operator(value = "eq", field = "state")
    private String state;

    @Operator(value = "eq", field = "describe")
    private String describe;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
