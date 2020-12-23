package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class MapInformationQueryParams {

    @Operator(value = "eq", field = "currentDate")
    private String currentDate;
    @Operator(value = "like", field = "information")
    private String information;

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
