package org.tonzoc.model.support;

import java.util.List;

public class AttStatTenderModel {
    private String tenderGuid;
    private String tenderName;
    private List<AttendanceStatModel> statModels;

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public List<AttendanceStatModel> getStatModels() {
        return statModels;
    }

    public void setStatModels(List<AttendanceStatModel> statModels) {
        this.statModels = statModels;
    }

    @Override
    public String toString() {
        return "AttStatTenderModel{" +
                "tenderGuid='" + tenderGuid + '\'' +
                ", tenderName='" + tenderName + '\'' +
                ", statModels=" + statModels +
                '}';
    }
}
