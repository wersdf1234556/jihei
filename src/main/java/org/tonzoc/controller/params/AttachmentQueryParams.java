package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

import java.sql.Date;

public class AttachmentQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    @Operator(value = "eq", field = "typeGuid")
    private String typeGuid;

    @Operator(value = "eq", field = "subTypeGuid")
    private String subTypeGuid;

    @Operator(value = "eq", field = "laboratoryGuid")
    private String laboratoryGuid;

    @Operator(value = "gte", field = "createdAt")
    private Date startTime;

    @Operator(value = "lte", field = "createdAt")
    private Date endTime;

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

    public String getTypeGuid() {
        return typeGuid;
    }

    public void setTypeGuid(String typeGuid) {
        this.typeGuid = typeGuid;
    }

    public String getSubTypeGuid() {
        return subTypeGuid;
    }

    public void setSubTypeGuid(String subTypeGuid) {
        this.subTypeGuid = subTypeGuid;
    }

    public String getLaboratoryGuid() {
        return laboratoryGuid;
    }

    public void setLaboratoryGuid(String laboratoryGuid) {
        this.laboratoryGuid = laboratoryGuid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
