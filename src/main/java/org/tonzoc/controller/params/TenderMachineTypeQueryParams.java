package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class TenderMachineTypeQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;

    @Operator(value = "or", field = "tenderGuid")
    private String tenderManage;

    @Operator(value = "eq", field = "machineTypeGuid")
    private String machineTypeGuid;

    @Operator(value = "like", field = "name")
    private String name;

    @Operator(value = "eq", field = "machineCategoryGuid")
    private String machineCategoryGuid;

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

    public String getTenderManage() {
        return tenderManage;
    }

    public void setTenderManage(String tenderManage) {
        this.tenderManage = tenderManage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMachineCategoryGuid() {
        return machineCategoryGuid;
    }

    public void setMachineCategoryGuid(String machineCategoryGuid) {
        this.machineCategoryGuid = machineCategoryGuid;
    }
}
