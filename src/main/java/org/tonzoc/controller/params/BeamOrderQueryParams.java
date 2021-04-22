package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BeamOrderQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "beamGuid")
    private String beamGuid;
    @Operator(value = "eq", field = "status")
    private String status; // 工序
    @Operator(value = "like", field = "attTime")
    private String attTime; // 施工日期
    @Operator(value = "eq", field = "sortId")
    private Integer sortId;
    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getBeamGuid() {
        return beamGuid;
    }

    public void setBeamGuid(String beamGuid) {
        this.beamGuid = beamGuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttTime() {
        return attTime;
    }

    public void setAttTime(String attTime) {
        this.attTime = attTime;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }
}
