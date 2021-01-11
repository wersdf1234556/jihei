package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class LabStressMachineQueryParams {

    @Operator(value = "gte", field = "testDate")
    private String startDate;

    @Operator(value = "lte", field = "testDate")
    private String endDate;

    @Operator(value = "like", field = "sectionName")
    private String tenderName;

    public LabStressMachineQueryParams() {

    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        System.out.println(startDate);
        this.startDate = startDate + " 00:00:00";
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate + " 23:59:59";
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }
}
