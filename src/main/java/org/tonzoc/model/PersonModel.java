package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "persons")
public class PersonModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name; // 名称
    @Column(value = "tenderGuid")
    private String tenderGuid; //标段
    @Column(value = "personTypeGuid")
    private String personTypeGuid; //工种guid
    @Column(value = "idCard")
    private String idCard;
    @Column(value = "password")
    private String password; //手机端密码，明文
    @Column(value = "categoryGuid")
    private String categoryGuid; //类别
    @Column(value = "mobile")
    private String mobile; //手机号
    @Column(value = "enterAreaTime")
    private String enterAreaTime; //进场时间
    @Column(value = "nativePlace")
    private String nativePlace;//籍贯
    @Column(value = "certificateName")
    private String certificateName;//证书名称
    @Column(value = "certificatePic")
    private String certificatePic; //证书照片
    @Column(value = "photo")
    private String photo; //人员照片
    @Column(value = "departurePlaceCode")
    private String departurePlaceCode; //出发地code
    @Column(value = "remark")
    private String remark;//补充地址信息
    @Column(value = "isRisk")
    private Integer isRisk; //是否从高风险地区来
    @Column(value = "vehicle")
    private String vehicle;
    @Column(value = "travelTime")
    private String travelTime;
    @Column(value = "trainNumber")
    private String trainNumber;
    @Column(value = "samplingOrgan")
    private String samplingOrgan;
    @Column(value = "samplingTime")
    private String samplingTime;
    @Column(value = "barCode")
    private String barCode;
    @Column(value = "sampleType")
    private Integer sampleType;
    @Column(value = "result")
    private Integer result;
    @Column(value = "reportTime")
    private String reportTime;
    @Column(value = "testingOrgan")
    private String testingOrgan;
    @Column(value = "testingAddress")
    private String testingAddress;
    @Column(value = "isGroup")
    private Integer isGroup;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName; //标段
    @JoinColumn(value = "name", type = PersonTypeModel.class, leftColumn = "personTypeGuid", rightColumn = "guid")
    private String typeName; //工种
    @JoinColumn(value = "name", type = PersonCategoryModel.class, leftColumn = "categoryGuid", rightColumn = "guid")
    private String categoryName; //类别
    @JoinColumn(value = "name", type = AttachmentModel.class, leftColumn = "photo", rightColumn = "guid")
    private String photoName; //人员照片名称
    @JoinColumn(value = "name", type = AttachmentModel.class, leftColumn = "certificatePic", rightColumn = "guid")

    private String certificatePicName; //证书照片名称

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

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getPersonTypeGuid() {
        return personTypeGuid;
    }

    public void setPersonTypeGuid(String personTypeGuid) {
        this.personTypeGuid = personTypeGuid;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategoryGuid() {
        return categoryGuid;
    }

    public void setCategoryGuid(String categoryGuid) {
        this.categoryGuid = categoryGuid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEnterAreaTime() {
        return enterAreaTime;
    }

    public void setEnterAreaTime(String enterAreaTime) {
        this.enterAreaTime = enterAreaTime;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificatePic() {
        return certificatePic;
    }

    public void setCertificatePic(String certificatePic) {
        this.certificatePic = certificatePic;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDeparturePlaceCode() {
        return departurePlaceCode;
    }

    public void setDeparturePlaceCode(String departurePlaceCode) {
        this.departurePlaceCode = departurePlaceCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsRisk() {
        return isRisk;
    }

    public void setIsRisk(Integer isRisk) {
        this.isRisk = isRisk;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getSamplingOrgan() {
        return samplingOrgan;
    }

    public void setSamplingOrgan(String samplingOrgan) {
        this.samplingOrgan = samplingOrgan;
    }

    public String getSamplingTime() {
        return samplingTime;
    }

    public void setSamplingTime(String samplingTime) {
        this.samplingTime = samplingTime;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getSampleType() {
        return sampleType;
    }

    public void setSampleType(Integer sampleType) {
        this.sampleType = sampleType;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getTestingOrgan() {
        return testingOrgan;
    }

    public void setTestingOrgan(String testingOrgan) {
        this.testingOrgan = testingOrgan;
    }

    public String getTestingAddress() {
        return testingAddress;
    }

    public void setTestingAddress(String testingAddress) {
        this.testingAddress = testingAddress;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getCertificatePicName() {
        return certificatePicName;
    }

    public void setCertificatePicName(String certificatePicName) {
        this.certificatePicName = certificatePicName;
    }

    public Integer getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Integer isGroup) {
        this.isGroup = isGroup;
    }
}
