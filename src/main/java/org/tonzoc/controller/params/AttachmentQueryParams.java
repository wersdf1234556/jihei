package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

import java.sql.Date;

public class AttachmentQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    @Operator(value = "eq", field = "qualityTraceabilityGuid")
    private String qualityTraceabilityGuid;

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

    public String getQualityTraceabilityGuid() {
        return qualityTraceabilityGuid;
    }

    public void setQualityTraceabilityGuid(String qualityTraceabilityGuid) {
        this.qualityTraceabilityGuid = qualityTraceabilityGuid;
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
