package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class QualityTraceabilityQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "eq", field = "currentTime")
    private String currentDate;

    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;

    @Operator(value = "eq", field = "typeId")
    private String typeId;

    @Operator(value = "eq", field = "subTypeGuid")
    private Integer subTypeGuid;

    @Operator(value = "eq", field = "qrcodeGuid")
    private String qrcodeGuid;

    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    @Operator(value = "like", field = "parts")
    private String parts;

    @Operator(value = "like", field = "major")
    private String major;


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

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Integer getSubTypeGuid() {
        return subTypeGuid;
    }

    public void setSubTypeGuid(Integer subTypeGuid) {
        this.subTypeGuid = subTypeGuid;
    }

    public String getQrcodeGuid() {
        return qrcodeGuid;
    }

    public void setQrcodeGuid(String qrcodeGuid) {
        this.qrcodeGuid = qrcodeGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
