package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class CameraQueryParams {

    @Operator(value = "like", field = "name")
    private String name;
    @Operator(value = "like", field = "deviceSerial")
    private String deviceSerial;
    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;
    @Operator(value = "eq", field = "typeGuid")
    private String typeGuid;
    @Operator(value = "eq", field = "status")
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getTypeGuid() {
        return typeGuid;
    }

    public void setTypeGuid(String typeGuid) {
        this.typeGuid = typeGuid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
