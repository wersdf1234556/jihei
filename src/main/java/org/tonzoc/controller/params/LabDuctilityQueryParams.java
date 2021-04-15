package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class LabDuctilityQueryParams {
    @Operator(value = "gte", field = "testDate")
    private String startDate;

    @Operator(value = "lte", field = "testDate")
    private String endDate;

    @Operator(value = "like", field = "sectionName")
    private String tenderName;

    @Operator(value = "eq", field = "sectionId")
    private String sectionId;

    @Operator(value = "eq", field = "flag")
    private Integer flag;

    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;

    @Operator(value = "or", field = "tenderGuid")
    private String tenderManage;

    public String getTenderManage() {
        return tenderManage;
    }

    public void setTenderManage(String tenderManage) {
        this.tenderManage = tenderManage;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        System.out.println(startDate);
        this.startDate = (startDate.equals("") ? "1900-01-01" : startDate) + " 00:00:00";
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = (endDate.equals("") ? "2090-12-31" : endDate) + " 23:59:59";
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

    public LabDuctilityQueryParams() {

    }

}
