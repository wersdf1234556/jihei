package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class ProgressDetailQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "progressNameGuid")
    private String progressNameGuid;
    @Operator(value = "or", field = "tenderGuid")
    private String tenderGuid;
    @Operator(value = "eq", field = "date")
    private String date;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getProgressNameGuid() {
        return progressNameGuid;
    }

    public void setProgressNameGuid(String progressNameGuid) {
        this.progressNameGuid = progressNameGuid;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
