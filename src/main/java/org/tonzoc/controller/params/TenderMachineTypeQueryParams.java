package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class TenderMachineTypeQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;

    @Operator(value = "eq", field = "machineTypeGuid")
    private String machineTypeGuid;

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

    public String getMachineTypeGuid() {
        return machineTypeGuid;
    }

    public void setMachineTypeGuid(String machineTypeGuid) {
        this.machineTypeGuid = machineTypeGuid;
    }
}
