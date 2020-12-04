package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "aerialPhotographyLocations")
public class AerialPhotographyLocationModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "lng")
    private String lng;
    @Column(value = "lat")
    private String lat;
    @Column(value = "time")
    private Integer time;
    @Column(value = "aerialPhotographyGuid")
    private String aerialPhotographyGuid;
    @Column(value = "altitude")
    private String altitude;

    public AerialPhotographyLocationModel() {
    }

    public AerialPhotographyLocationModel(String guid, String lng, String lat, Integer time, String aerialPhotographyGuid, String altitude) {
        this.guid = guid;
        this.lng = lng;
        this.lat = lat;
        this.time = time;
        this.aerialPhotographyGuid = aerialPhotographyGuid;
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "AerialPhotographyLocationModel{" +
                "guid='" + guid + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", time=" + time +
                ", aerialPhotographyGuid='" + aerialPhotographyGuid + '\'' +
                ", altitude='" + altitude + '\'' +
                '}';
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getAerialPhotographyGuid() {
        return aerialPhotographyGuid;
    }

    public void setAerialPhotographyGuid(String aerialPhotographyGuid) {
        this.aerialPhotographyGuid = aerialPhotographyGuid;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }
}
