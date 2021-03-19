package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BuildingSafetyDetailQueryParams {
    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "safetyGuid")
    private String safetyGuid;
    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;
    @Operator(value = "like", field = "date")
    private String date;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }


    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getSafetyGuid() {
        return safetyGuid;
    }

    public void setSafetyGuid(String safetyGuid) {
        this.safetyGuid = safetyGuid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
