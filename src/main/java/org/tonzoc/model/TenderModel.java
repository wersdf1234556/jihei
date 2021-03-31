package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;
import org.tonzoc.model.support.ReturnMachineModel;

import java.math.BigDecimal;
import java.util.List;

@Table("tenders")
public class TenderModel extends BaseModel {

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "lng")
    private String lng;
    @Column(value = "lat")
    private String lat;
    @Column(value = "scale")
    private Integer scale;
    @Column(value = "organization")
    private String organization; // 单位名称

    private List<ReturnModel> list; // 质量使用
    private List<ReturnMachineModel> listMachine; //机械返回值用

    public TenderModel() {
    }

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

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public List<ReturnMachineModel> getListMachine() {
        return listMachine;
    }

    public void setListMachine(List<ReturnMachineModel> listMachine) {
        this.listMachine = listMachine;
    }

    public List<ReturnModel> getList() {
        return list;
    }

    public void setList(List<ReturnModel> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "TenderModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", sortId=" + sortId +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", scale=" + scale +
                ", organization='" + organization + '\'' +
                ", list=" + list +
                ", listMachine=" + listMachine +
                '}';
    }
}
