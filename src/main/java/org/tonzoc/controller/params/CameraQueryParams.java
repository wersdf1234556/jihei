package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class CameraQueryParams {

    @Operator(value = "eq", field = "name")
    private String name;
    @Operator(value = "eq", field = "deviceSerial")
    private String deviceSerial;
    @Operator(value = "eq", field = "tenderName")
    private String tenderName;
    @Operator(value = "eq", field = "typeName")
    private String typeName;

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

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
