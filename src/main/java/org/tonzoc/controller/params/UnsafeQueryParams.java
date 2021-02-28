package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class UnsafeQueryParams {

    @Operator(value = "eq", field = "guid")
    private Integer guid;

    @Operator(value = "like", field = "grade")
    private String grade;

    @Operator(value = "like", field = "parts")
    private String parts;

    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;

    public Integer getGuid() {
        return guid;
    }

    public void setGuid(Integer guid) {
        this.guid = guid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }
}
