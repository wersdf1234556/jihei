package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class StakeQueryParams {

    @Operator(value = "or", field = "tenderGuid")
    private String tenderGuid;

    public StakeQueryParams() {

    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }
}
