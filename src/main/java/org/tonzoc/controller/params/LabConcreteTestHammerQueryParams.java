package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class LabConcreteTestHammerQueryParams {
    @Operator(value = "gte", field = "testDate")
    private String startDate;

    @Operator(value = "lte", field = "testDate")
    private String endDate;

    @Operator(value = "like", field = "sectionName")
    private String tenderName;

    @Operator(value = "eq", field = "sectionId")
    private String sectionId;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public LabConcreteTestHammerQueryParams() {

    }

}
