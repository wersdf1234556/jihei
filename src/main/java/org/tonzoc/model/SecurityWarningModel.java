package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "securityWarnings")
public class SecurityWarningModel extends BaseModel {
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "hardwareid")
    private String hardwareid;
    @Column(value = "datetime")
    private String datetime;
    @Column(value = "image")
    private String image;
    @Column(value = "type")
    private Integer type;
    @Column(value = "location")
    private String location;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getHardwareid() {
        return hardwareid;
    }

    public void setHardwareid(String hardwareid) {
        this.hardwareid = hardwareid;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public SecurityWarningModel() {
    }
}
