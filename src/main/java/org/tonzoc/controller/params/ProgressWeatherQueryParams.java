package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class ProgressWeatherQueryParams {
    @Operator(value = "gte", field = "date")
    private String startDate;

    @Operator(value = "lte", field = "date")
    private String endDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        System.out.println(startDate);
        this.startDate = (startDate.equals("") ? "1900-01-01" : startDate);
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = (endDate.equals("") ? "2090-12-31" : endDate);
    }
}
