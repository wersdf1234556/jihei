package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class MachineQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "machineKey")
    private String machineKey; // 机械编号
    @Operator(value = "like", field = "name")
    private String name;
    @Operator(value = "eq", field = "tenderMachineTypeGuid")
    private String  tenderMachineTypeGuid;
    @Operator(value = "eq", field = "machineCategoryGuid")
    private String machineCategoryGuid;
    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;
    @Operator(value = "or", field = "tenderGuid")
    private String tenderManage;
    @Operator(value = "eq", field = "HGPSID")
    private String HGPSID;
    @Operator(value = "eq", field = "lng")
    private String lng;
    @Operator(value = "eq", field = "lat")
    private String lat;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getMachineKey() {
        return machineKey;
    }

    public void setMachineKey(String machineKey) {
        this.machineKey = machineKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTenderMachineTypeGuid() {
        return tenderMachineTypeGuid;
    }

    public void setTenderMachineTypeGuid(String tenderMachineTypeGuid) {
        this.tenderMachineTypeGuid = tenderMachineTypeGuid;
    }

    public String getMachineCategoryGuid() {
        return machineCategoryGuid;
    }

    public void setMachineCategoryGuid(String machineCategoryGuid) {
        this.machineCategoryGuid = machineCategoryGuid;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getTenderManage() {
        return tenderManage;
    }

    public void setTenderManage(String tenderManage) {
        this.tenderManage = tenderManage;
    }

    public String getHGPSID() {
        return HGPSID;
    }

    public void setHGPSID(String HGPSID) {
        this.HGPSID = HGPSID;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
