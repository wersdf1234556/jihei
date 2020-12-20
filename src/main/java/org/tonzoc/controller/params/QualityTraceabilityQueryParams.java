package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

import java.sql.Date;

public class QualityTraceabilityQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "eq", field = "currentDate")
    private Date currentDate;

    @Operator(value = "eq", field = "qualityType")
    private String qualityType;

    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;

    @Operator(value = "eq", field = "subTypeGuid")
    private String subTypeGuid;

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

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getSubTypeGuid() {
        return subTypeGuid;
    }

    public void setSubTypeGuid(String subTypeGuid) {
        this.subTypeGuid = subTypeGuid;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getQualityType() {
        return qualityType;
    }

    public void setQualityType(String qualityType) {
        this.qualityType = qualityType;
    }
}
