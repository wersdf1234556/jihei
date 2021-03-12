package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 管理权属
@Table("managementPowers")
public class ManagementPowerModel extends BaseModel{

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "industryCategoryGuid")
    private String industryCategoryGuid; // 行业类别
    @Column(value = "videoUrl")
    private String videoUrl; // 视频地址

    @JoinColumn(value = "name", type = IndustryCategoryModel.class, leftColumn = "industryCategoryGuid", rightColumn = "guid")
    private String industryCategoryName;  // 行业名称

    public ManagementPowerModel() {
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

    public String getIndustryCategoryGuid() {
        return industryCategoryGuid;
    }

    public void setIndustryCategoryGuid(String industryCategoryGuid) {
        this.industryCategoryGuid = industryCategoryGuid;
    }

    public String getIndustryCategoryName() {
        return industryCategoryName;
    }

    public void setIndustryCategoryName(String industryCategoryName) {
        this.industryCategoryName = industryCategoryName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "ManagementPowerModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", sortId=" + sortId +
                ", industryCategoryGuid='" + industryCategoryGuid + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", industryCategoryName='" + industryCategoryName + '\'' +
                '}';
    }
}
