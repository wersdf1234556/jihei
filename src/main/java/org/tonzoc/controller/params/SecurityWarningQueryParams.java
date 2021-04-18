package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class SecurityWarningQueryParams {
    @Operator(value = "gte", field = "datetime")
    private String startDate;

    @Operator(value = "lte", field = "datetime")
    private String endDate;

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
}
