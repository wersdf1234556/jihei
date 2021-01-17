package org.tonzoc.model.support;

public class LabStressMachineStatModel {
    private String tenderGuid;
    private String tenderName;
    private Integer num;

    public LabStressMachineStatModel(String tenderGuid, String tenderName, Integer num) {
        this.tenderGuid = tenderGuid;
        this.tenderName = tenderName;
        this.num = num;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }
}
