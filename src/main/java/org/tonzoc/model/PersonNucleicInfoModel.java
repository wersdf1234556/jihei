package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "personNucleicInfo")
public class PersonNucleicInfoModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "personGuid")
    private String personGuid;
    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "personGuid", rightColumn = "guid")
    private String personName; //人员姓名
    @Column(value = "departurePlaceCode")
    private String departurePlaceCode; //出发地code
    @JoinColumn(value = "name", type = AreaDataModel.class, leftColumn = "departurePlaceCode", rightColumn = "code")
    private String departurePlace; //出发地
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
    @Column(value = "address")
    private String address;


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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

    @Override
    public String toString() {
        return "PersonNucleicInfoModel{" +
                "guid='" + guid + '\'' +
                ", personGuid='" + personGuid + '\'' +
                ", personName='" + personName + '\'' +
                ", departurePlaceCode='" + departurePlaceCode + '\'' +
                ", departurePlace='" + departurePlace + '\'' +
                ", isRisk=" + isRisk +
                ", vehicle='" + vehicle + '\'' +
                ", travelTime='" + travelTime + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", samplingOrgan='" + samplingOrgan + '\'' +
                ", samplingTime='" + samplingTime + '\'' +
                ", barCode='" + barCode + '\'' +
                ", sampleType=" + sampleType +
                ", result=" + result +
                ", reportTime='" + reportTime + '\'' +
                ", testingOrgan='" + testingOrgan + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
