package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 机械基础表
@Table("machines")
public class MachineModel extends BaseModel {

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "machineKey")
    private String machineKey; // 机械编号
    @Column(value = "name")
    private String name; // 机械名称
    @Column(value = "ownerName")
    private String ownerName; // 车主
    @Column(value = "ownerPhone")
    private String ownerPhone; // 车主电话
    @Column(value = "driverName")
    private String driverName; // 当前司机
    @Column(value = "driverPhone")
    private String driverPhone; // 当前司机电话
    @Column(value = "urgentPhone")
    private String urgentPhone; //紧急联系电话
    @Column(value = "purchaseDate")
    private String purchaseDate; // 进场日期
    @Column(value = "departureDate")
    private String departureDate; //离场日期
    @Column(value = "brandName")
    private String brandName; // 品牌
    @Column(value = "factoryDate")
    private String factoryDate; // 生产日期
    @Column(value = "age")
    private String age; // 使用年限
    @Column(value = "sortId")
    private Integer sortId; // 排序
    @Column(value = "machineTypeGuid")
    private String machineTypeGuid; // 类型的guid
    @Column(value = "machineCategoryGuid")
    private String machineCategoryGuid; // 类别的guid
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "HGPSID")
    private String HGPSID;

    @JoinColumn(value = "name", type = MachineTypeModel.class, leftColumn = "machineTypeGuid", rightColumn = "guid")
    private String typeName;
    @JoinColumn(value = "name", type = MachineCategoryModel.class, leftColumn = "machineCategoryGuid", rightColumn = "guid")
    private String categoryName;
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;

    public MachineModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getMachineKey() {
        return machineKey;
    }

    public void setMachineKey(String machineKey) {
        this.machineKey = machineKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getUrgentPhone() {
        return urgentPhone;
    }

    public void setUrgentPhone(String urgentPhone) {
        this.urgentPhone = urgentPhone;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getFactoryDate() {
        return factoryDate;
    }

    public void setFactoryDate(String factoryDate) {
        this.factoryDate = factoryDate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getMachineTypeGuid() {
        return machineTypeGuid;
    }

    public void setMachineTypeGuid(String machineTypeGuid) {
        this.machineTypeGuid = machineTypeGuid;
    }

    public String getMachineCategoryGuid() {
        return machineCategoryGuid;
    }

    public void setMachineCategoryGuid(String machineCategoryGuid) {
        this.machineCategoryGuid = machineCategoryGuid;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getHGPSID() {
        return HGPSID;
    }

    public void setHGPSID(String HGPSID) {
        this.HGPSID = HGPSID;
    }

    @Override
    public String toString() {
        return "MachineModel{" +
                "guid='" + guid + '\'' +
                ", machineKey='" + machineKey + '\'' +
                ", name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverPhone='" + driverPhone + '\'' +
                ", urgentPhone='" + urgentPhone + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", brandName='" + brandName + '\'' +
                ", factoryDate='" + factoryDate + '\'' +
                ", age='" + age + '\'' +
                ", sortId=" + sortId +
                ", machineTypeGuid='" + machineTypeGuid + '\'' +
                ", machineCategoryGuid='" + machineCategoryGuid + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", HGPSID='" + HGPSID + '\'' +
                ", typeName='" + typeName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", tenderName='" + tenderName + '\'' +
                '}';
    }
}
