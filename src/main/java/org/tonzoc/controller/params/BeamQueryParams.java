package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BeamQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "beamPedestalGuid")
    private String beamPedestalGuid;
    @Operator(value = "eq", field = "beamPrefabricationGuid")
    private String beamPrefabricationGuid;
    @Operator(value = "eq", field = "sortId")
    private Integer sortId;
    @Operator(value = "like", field = "attTime")
    private String attTime;
    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;
    @Operator(value = "gte", field = "attTime")
    private String startTime;
    @Operator(value = "lte", field = "attTime")
    private String endTime;
    @Operator(value = "eq", field = "beamPrefabricationsStatusbeamPrefabricationStatusTable.status")
    private String beamPrefabricationStatus;
    @Operator(value = "eq", field = "beamPrefabricationsNamebeamPrefabricationNameTable.name")
    private String beamPrefabricationName;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getBeamPedestalGuid() {
        return beamPedestalGuid;
    }

    public void setBeamPedestalGuid(String beamPedestalGuid) {
        this.beamPedestalGuid = beamPedestalGuid;
    }

    public String getBeamPrefabricationGuid() {
        return beamPrefabricationGuid;
    }

    public void setBeamPrefabricationGuid(String beamPrefabricationGuid) {
        this.beamPrefabricationGuid = beamPrefabricationGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getAttTime() {
        return attTime;
    }

    public void setAttTime(String attTime) {
        this.attTime = attTime;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBeamPrefabricationStatus() {
        return beamPrefabricationStatus;
    }

    public void setBeamPrefabricationStatus(String beamPrefabricationStatus) {
        this.beamPrefabricationStatus = beamPrefabricationStatus;
    }

    public String getBeamPrefabricationName() {
        return beamPrefabricationName;
    }

    public void setBeamPrefabricationName(String beamPrefabricationName) {
        this.beamPrefabricationName = beamPrefabricationName;
    }
}
