package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.*;

import java.util.List;

@Table(value = "securityResults")
public class SecurityResultModel extends BaseModel {
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "devId")
    private String devId;
    @Column(value = "chnName")
    private String chnName;
    @Column(value = "chnId")
    private Integer chnId;
    @Column(value = "imgData")
    private String imgData;
    @Column(value = "stamp")
    private String stamp;
    @Column(value = "algType")
    private Integer algType;
    @Column(value = "remark")
    private String remark;
    @Column(value = "imageUrl")
    private String imageUrl;

    private List<SecurityResultDetailModel> data;

    public List<SecurityResultDetailModel> getData() {
        return data;
    }

    public void setData(List<SecurityResultDetailModel> data) {
        this.data = data;
    }

    public SecurityResultModel() {
    }

    public String getGuid() {
        return guid;
    }

    public String getDevId() {
        return devId;
    }

    public String getChnName() {
        return chnName;
    }

    public Integer getChnId() {
        return chnId;
    }

    public String getImgData() {
        return imgData;
    }

    public String getStamp() {
        return stamp;
    }

    public Integer getAlgType() {
        return algType;
    }

    public String getRemark() {
        return remark;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty(value = "dev_id")
    public void setDevId(String devId) {
        this.devId = devId;
    }

    @JsonProperty(value = "chn_name")
    public void setChnName(String chnName) {
        this.chnName = chnName;
    }

    @JsonProperty(value = "chn_id")
    public void setChnId(Integer chnId) {
        this.chnId = chnId;
    }

    @JsonProperty(value = "img_data")
    public void setImgData(String imgData) {
        this.imgData = imgData;
    }

    @JsonProperty(value = "stamp")
    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    @JsonProperty(value = "alg_type")
    public void setAlgType(Integer algType) {
        this.algType = algType;
    }

    @JsonProperty(value = "remark")
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @JsonProperty(value = "image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "SecurityResultModel{" +
                "guid='" + guid + '\'' +
                ", devId='" + devId + '\'' +
                ", chnName='" + chnName + '\'' +
                ", chnId=" + chnId +
                ", imgData='" + imgData + '\'' +
                ", stamp='" + stamp + '\'' +
                ", algType=" + algType +
                ", remark='" + remark + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", data=" + data +
                '}';
    }
}
