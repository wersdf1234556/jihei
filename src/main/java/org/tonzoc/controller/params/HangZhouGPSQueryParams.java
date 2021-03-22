package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class HangZhouGPSQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "HGPSID")
    private String HGPSID;
    @Operator(value = "like", field = "HSpeed")
    private String HSpeed;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getHGPSID() {
        return HGPSID;
    }

    public void setHGPSID(String HGPSID) {
        this.HGPSID = HGPSID;
    }

    public String getHSpeed() {
        return HSpeed;
    }

    public void setHSpeed(String HSpeed) {
        this.HSpeed = HSpeed;
    }
}
