package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

// 机械GPS表
@Table("HangZhouGPS")
public class HangZhouGPSModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "HType")
    private String HType;
    @Column(value = "HGPSID")
    private String HGPSID;
    @Column(value = "HGPSN")
    private String HGPSN;
    @Column(value = "HGPSE")
    private String HGPSE;
    @Column(value = "HSpeed")
    private String HSpeed;
    @Column(value = "HDate")
    private String HDate;
    @Column(value = "IsParsed")
    private Integer IsParsed;
    @Column(value = "RefinedLng")
    private String RefinedLng;
    @Column(value = "RefinedLat")
    private String RefinedLat;
    @Column(value = "BaiduLng")
    private String BaiduLng;
    @Column(value = "BaiduLat")
    private String BaiduLat;

    public HangZhouGPSModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getHType() {
        return HType;
    }

    public void setHType(String HType) {
        this.HType = HType;
    }

    public String getHGPSID() {
        return HGPSID;
    }

    public void setHGPSID(String HGPSID) {
        this.HGPSID = HGPSID;
    }

    public String getHGPSN() {
        return HGPSN;
    }

    public void setHGPSN(String HGPSN) {
        this.HGPSN = HGPSN;
    }

    public String getHGPSE() {
        return HGPSE;
    }

    public void setHGPSE(String HGPSE) {
        this.HGPSE = HGPSE;
    }

    public String getHSpeed() {
        return HSpeed;
    }

    public void setHSpeed(String HSpeed) {
        this.HSpeed = HSpeed;
    }

    public String getHDate() {
        return HDate;
    }

    public void setHDate(String HDate) {
        this.HDate = HDate;
    }

    public Integer getIsParsed() {
        return IsParsed;
    }

    public void setIsParsed(Integer isParsed) {
        IsParsed = isParsed;
    }

    public String getRefinedLng() {
        return RefinedLng;
    }

    public void setRefinedLng(String refinedLng) {
        RefinedLng = refinedLng;
    }

    public String getRefinedLat() {
        return RefinedLat;
    }

    public void setRefinedLat(String refinedLat) {
        RefinedLat = refinedLat;
    }

    public String getBaiduLng() {
        return BaiduLng;
    }

    public void setBaiduLng(String baiduLng) {
        BaiduLng = baiduLng;
    }

    public String getBaiduLat() {
        return BaiduLat;
    }

    public void setBaiduLat(String baiduLat) {
        BaiduLat = baiduLat;
    }
}