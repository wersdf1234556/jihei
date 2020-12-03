package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.JoinColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

import javax.validation.constraints.NotEmpty;

@Table(value = "aerialPhotographys")
public class AerialPhotographyModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @NotEmpty
    @Column(value = "name")
    private String name;
    @Column(value = "url")
    private String url;
    @Column(value = "month")
    private String month;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "sortId")
    private Integer sortId;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;
    @JoinColumn(value = "lng", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String lng;
    @JoinColumn(value = "lat", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String lat;
    @JoinColumn(value = "scale", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private Integer scale;

    public AerialPhotographyModel() {
    }

    public AerialPhotographyModel(String guid, @NotEmpty String name, String url, String month, String tenderGuid, Integer sortId, String tenderName, String lng, String lat, Integer scale) {
        this.guid = guid;
        this.name = name;
        this.url = url;
        this.month = month;
        this.tenderGuid = tenderGuid;
        this.sortId = sortId;
        this.tenderName = tenderName;
        this.lng = lng;
        this.lat = lat;
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "AerialPhotographyModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", month='" + month + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", sortId=" + sortId +
                ", tenderName='" + tenderName + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", scale=" + scale +
                '}';
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
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
}
