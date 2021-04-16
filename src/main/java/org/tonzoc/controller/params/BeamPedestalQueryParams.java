package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BeamPedestalQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "like", field = "name")
    private String name;
    @Operator(value = "eq", field = "sortId")
    private Integer sortId;
    @Operator(value = "like", field = "attTime")
    private String attTime;
    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;
    @Operator(value = "eq", field = "modelNum")
    private String modelNum;
    @Operator(value = "eq", field = "pedestalNum")
    private String pedestalNum;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public String getPedestalNum() {
        return pedestalNum;
    }

    public void setPedestalNum(String pedestalNum) {
        this.pedestalNum = pedestalNum;
    }
}
