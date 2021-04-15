package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BeamOrderQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "beamGuid")
    private String beamGuid;
    @Operator(value = "like", field = "orders")
    private String orders; // 工序
    @Operator(value = "eq", field = "dates")
    private String dates; // 施工日期
    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

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

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
