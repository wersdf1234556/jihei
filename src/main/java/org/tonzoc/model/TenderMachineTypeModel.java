package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "TenderMachineTypes")
public class TenderMachineTypeModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "machineTypeGuid")
    private String machineTypeGuid;
    @Column(value = "name")
    private String name;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "defaultNum")
    private String defaultNum;
    @Column(value = "machineCategoryGuid")
    private String machineCategoryGuid;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段名称
    @JoinColumn(value = "name", type = MachineTypeModel.class, leftColumn = "machineTypeGuid", rightColumn = "guid")
    private String MachineTypeName;  // 机械类型名称
    @JoinColumn(value = "name", type = MachineCategoryModel.class, leftColumn = "machineCategoryGuid", rightColumn = "guid")
    private String machineCategoryName;  // 机械类别名称

    public TenderMachineTypeModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getMachineTypeGuid() {
        return machineTypeGuid;
    }

    public void setMachineTypeGuid(String machineTypeGuid) {
        this.machineTypeGuid = machineTypeGuid;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getMachineTypeName() {
        return MachineTypeName;
    }

    public void setMachineTypeName(String machineTypeName) {
        MachineTypeName = machineTypeName;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultNum() {
        return defaultNum;
    }

    public void setDefaultNum(String defaultNum) {
        this.defaultNum = defaultNum;
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
}
