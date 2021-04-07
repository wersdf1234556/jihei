package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 机械类型表
@Table("machineTypes")
public class MachineTypeModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "highlight")
    private Integer highlight; // 是否重点展示
    @Column(value = "machineCategoryGuid")
    private String machineCategoryGuid; // 机械类别guid
    @Column(value = "formattedName")
    private String formattedName; // 机械名称分割

    @JoinColumn(value = "name", type = MachineCategoryModel.class, leftColumn = "machineCategoryGuid", rightColumn = "guid")
    private String machineCategoryName;  // 机械类别名称

    public MachineTypeModel() {
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

    public Integer getHighlight() {
        return highlight;
    }

    public void setHighlight(Integer highlight) {
        this.highlight = highlight;
    }

    public String getMachineCategoryGuid() {
        return machineCategoryGuid;
    }

    public void setMachineCategoryGuid(String machineCategoryGuid) {
        this.machineCategoryGuid = machineCategoryGuid;
    }

    public String getMachineCategoryName() {
        return machineCategoryName;
    }

    public void setMachineCategoryName(String machineCategoryName) {
        this.machineCategoryName = machineCategoryName;
    }

    public String getFormattedName() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    @Override
    public String toString() {
        return "MachineTypeModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", sortId=" + sortId +
                ", highlight=" + highlight +
                ", machineCategoryGuid='" + machineCategoryGuid + '\'' +
                ", formattedName='" + formattedName + '\'' +
                ", machineCategoryName='" + machineCategoryName + '\'' +
                '}';
    }
}
