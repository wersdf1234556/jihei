package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table("tenders")
public class TenderModel extends BaseModel {

    @PrimaryKey
    @NotInsertColumn
    @Column("guid")
    private String guid;
    @Column("name")
    private String name;
    @Column("sortId")
    private Integer sortId;
    @Column("lng")
    private String lng;
    @Column("lat")
    private String lat;
    @Column("scale")
    private Integer scale;

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

    @Override
    public String toString() {
        return "TenderModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", sortId=" + sortId +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", scale=" + scale +
                '}';
    }
}
