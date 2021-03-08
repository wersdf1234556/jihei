package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 等级
@Table("buildLevels")
public class BuildLevelModel extends BaseModel{

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
    @Column(value = "managementPowerGuid")
    private String managementPowerGuid; // 管理权属

    @JoinColumn(value = "name", type = IndustryCategoryModel.class, leftColumn = "industryCategoryGuid", rightColumn = "guid")
    private String industryCategoryName;  // 行业类别名称
    @JoinColumn(value = "name", type = ManagementPowerModel.class, leftColumn = "managementPowerGuid", rightColumn = "guid")
    private String managementPowerName;  // 管理权属名称

    public BuildLevelModel() {
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

    public String getManagementPowerGuid() {
        return managementPowerGuid;
    }

    public void setManagementPowerGuid(String managementPowerGuid) {
        this.managementPowerGuid = managementPowerGuid;
    }

    public String getIndustryCategoryName() {
        return industryCategoryName;
    }

    public void setIndustryCategoryName(String industryCategoryName) {
        this.industryCategoryName = industryCategoryName;
    }

    public String getManagementPowerName() {
        return managementPowerName;
    }

    public void setManagementPowerName(String managementPowerName) {
        this.managementPowerName = managementPowerName;
    }

    @Override
    public String toString() {
        return "BuildLevelModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", sortId=" + sortId +
                ", industryCategoryGuid='" + industryCategoryGuid + '\'' +
                ", managementPowerGuid='" + managementPowerGuid + '\'' +
                ", industryCategoryName='" + industryCategoryName + '\'' +
                ", managementPowerName='" + managementPowerName + '\'' +
                '}';
    }
}
