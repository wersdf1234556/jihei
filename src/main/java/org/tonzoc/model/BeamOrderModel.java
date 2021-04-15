package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 梁工序表
@Table(value = "beamOrders")
public class BeamOrderModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "beamGuid")
    private String beamGuid;
    @Column(value = "orders")
    private String orders; // 工序
    @Column(value = "dates")
    private String dates; // 施工日期
    @Column(value = "sortId")
    private Integer sortId;

    // @JoinColumn(value = "", type = BeamModel.class, leftColumn = "beamGuid", rightColumn = "guid")

    public BeamOrderModel() {
    }

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
