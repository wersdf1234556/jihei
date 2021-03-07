package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class AerialPhotographyQueryParams {

    @Operator(value = "like", field = "name")
    private String name;

    @Operator(value = "like", field = "month")
    private String month;

    @Operator(value = "or", field = "tenderGuid")
    private String tenderGuid;

    public AerialPhotographyQueryParams() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }
}
