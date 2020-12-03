package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class CameraQueryParams {

    @Operator(value = "eq", field = "name")
    private String name;
    @Operator(value = "eq", field = "deviceSerial")
    private String deviceSerial;
    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;
    @Operator(value = "eq", field = "typeGuid")
    private String typeGuid;

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
}
