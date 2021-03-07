package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class ProgressTotalDataQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "progressNameGuid")
    private String progressNameGuid;
    @Operator(value = "or", field = "tenderGuid")
    private String tenderGuid;

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

}
