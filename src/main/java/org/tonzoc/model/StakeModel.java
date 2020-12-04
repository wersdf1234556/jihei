<<<<<<< HEAD
package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "stakes")
public class StakeModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "lng")
    private String lng;
    @Column(value = "lat")
    private String lat;
    @Column(value = "height")
    private String height;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "sortId")
    private Integer sortId;

    public StakeModel() {
    }

    public StakeModel(String guid, String name, String lng, String lat, String height, String tenderGuid, Integer sortId) {
        this.guid = guid;
        this.name = name;
        this.lng = lng;
        this.lat = lat;
        this.height = height;
        this.tenderGuid = tenderGuid;
        this.sortId = sortId;
    }

    @Override
    public String toString() {
        return "StakeModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", height='" + height + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", sortId=" + sortId +
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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
}
=======
package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "stakes")
public class StakeModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "lng")
    private String lng;
    @Column(value = "lat")
    private String lat;
    @Column(value = "height")
    private String height;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "sortId")
    private Integer sortId;

    public StakeModel() {
    }

    public StakeModel(String guid, String name, String lng, String lat, String height, String tenderGuid, Integer sortId) {
        this.guid = guid;
        this.name = name;
        this.lng = lng;
        this.lat = lat;
        this.height = height;
        this.tenderGuid = tenderGuid;
        this.sortId = sortId;
    }

    @Override
    public String toString() {
        return "StakeModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", height='" + height + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", sortId=" + sortId +
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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
}
>>>>>>> origin/master
