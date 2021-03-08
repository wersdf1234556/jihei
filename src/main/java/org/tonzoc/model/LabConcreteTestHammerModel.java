package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labConcreteTestHammers")
public class LabConcreteTestHammerModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "equipmentNumber")
    private String equipmentNumber;
    @Column(value = "sensorNumber")
    private String sensorNumber;
    @Column(value = "entrustCompany")
    private String entrustCompany;
    @Column(value = "entrustName")
    private String entrustName;
    @Column(value = "projectName")
    private String projectName;
    @Column(value = "componentName")
    private String componentName;
    @Column(value = "componentNumber")
    private String componentNumber;
    @Column(value = "detectionTime")
    private String detectionTime;
    @Column(value = "pouringDate")
    private String pouringDate;
    @Column(value = "designGrade")
    private String designGrade;
    @Column(value = "componentStrength")
    private String componentStrength;
    @Column(value = "areaTotal")
    private String areaTotal;
    @Column(value = "areaNo")
    private String areaNo;
    @Column(value = "reboundData")
    private String reboundData;
    @Column(value = "testAngle")
    private String testAngle;
    @Column(value = "testSurface")
    private Integer testSurface;
    @Column(value = "sideIsdry")
    private Integer sideIsdry;
    @Column(value = "sideRough")
    private Integer sideRough;
    @Column(value = "carbonationDepthofcomponents")
    private String carbonationDepthofcomponents;
    @Column(value = "carbonationDepthdata")
    private String carbonationDepthdata;
    @Column(value = "age")
    private Integer age;
    @Column(value = "detectionParam")
    private String detectionParam;
    @Column(value = "sectionId")
    private String sectionId;
    @Column(value = "equipmentName")
    private String equipmentName;
    @Column(value = "entrustNumber")
    private String entrustNumber;

    public LabConcreteTestHammerModel() {
    }

    public LabConcreteTestHammerModel(String guid, String equipmentNumber, String sensorNumber, String entrustCompnay, String entrustName, String projectName, String componentName, String componentNumber, String detectionTime, String pouringDate, String designGrade, String componentStrength, String areaTotal, String areaNo, String reboundData, String testAngle, Integer testSurface, Integer sideIsdry, Integer sideRough, String carbonationDepthofcomponents, String carbonationDepthdata, Integer age, String detectionParam, String sectionId, String equipmentName, String entrustNumber) {
        this.guid = guid;
        this.equipmentNumber = equipmentNumber;
        this.sensorNumber = sensorNumber;
        this.entrustCompany = entrustCompnay;
        this.entrustName = entrustName;
        this.projectName = projectName;
        this.componentName = componentName;
        this.componentNumber = componentNumber;
        this.detectionTime = detectionTime;
        this.pouringDate = pouringDate;
        this.designGrade = designGrade;
        this.componentStrength = componentStrength;
        this.areaTotal = areaTotal;
        this.areaNo = areaNo;
        this.reboundData = reboundData;
        this.testAngle = testAngle;
        this.testSurface = testSurface;
        this.sideIsdry = sideIsdry;
        this.sideRough = sideRough;
        this.carbonationDepthofcomponents = carbonationDepthofcomponents;
        this.carbonationDepthdata = carbonationDepthdata;
        this.age = age;
        this.detectionParam = detectionParam;
        this.sectionId = sectionId;
        this.equipmentName = equipmentName;
        this.entrustNumber = entrustNumber;
    }

    @JsonProperty(value = "id")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty(value = "equipment_number")
    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    @JsonProperty(value = "sensor_number")
    public void setSensorNumber(String sensorNumber) {
        this.sensorNumber = sensorNumber;
    }

    @JsonProperty(value = "entrust_company")
    public void setEntrustCompany(String entrustCompany) {
        this.entrustCompany = entrustCompany;
    }

    @JsonProperty(value = "entrust_name")
    public void setEntrustName(String entrustName) {
        this.entrustName = entrustName;
    }

    @JsonProperty(value = "project_name")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @JsonProperty(value = "component_name")
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    @JsonProperty(value = "component_number")
    public void setComponentNumber(String componentNumber) {
        this.componentNumber = componentNumber;
    }

    @JsonProperty(value = "detectionTime")
    public void setDetectionTime(String detectionTime) {
        this.detectionTime = detectionTime;
    }

    @JsonProperty(value = "pouring_date")
    public void setPouringDate(String pouringDate) {
        this.pouringDate = pouringDate;
    }

    @JsonProperty(value = "design_grade")
    public void setDesignGrade(String designGrade) {
        this.designGrade = designGrade;
    }

    @JsonProperty(value = "component_strength")
    public void setComponentStrength(String componentStrength) {
        this.componentStrength = componentStrength;
    }

    @JsonProperty(value = "area_total")
    public void setAreaTotal(String areaTotal) {
        this.areaTotal = areaTotal;
    }

    @JsonProperty(value = "area_no")
    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    @JsonProperty(value = "rebound_data")
    public void setReboundData(String reboundData) {
        this.reboundData = reboundData;
    }

    @JsonProperty(value = "test_angle")
    public void setTestAngle(String testAngle) {
        this.testAngle = testAngle;
    }

    @JsonProperty(value = "test_surface")
    public void setTestSurface(Integer testSurface) {
        this.testSurface = testSurface;
    }

    @JsonProperty(value = "side_isdry")
    public void setSideIsdry(Integer sideIsdry) {
        this.sideIsdry = sideIsdry;
    }

    @JsonProperty(value = "side_rough")
    public void setSideRough(Integer sideRough) {
        this.sideRough = sideRough;
    }

    @JsonProperty(value = "carbonation_depthofcomponents")
    public void setCarbonationDepthofcomponents(String carbonationDepthofcomponents) {
        this.carbonationDepthofcomponents = carbonationDepthofcomponents;
    }

    @JsonProperty(value = "carbonation_depthdata")
    public void setCarbonationDepthdata(String carbonationDepthdata) {
        this.carbonationDepthdata = carbonationDepthdata;
    }

    @JsonProperty(value = "age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty(value = "detection_param")
    public void setDetectionParam(String detectionParam) {
        this.detectionParam = detectionParam;
    }

    public String getGuid() {
        return guid;
    }


    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public String getSensorNumber() {
        return sensorNumber;
    }

    public String getEntrustCompany() {
        return entrustCompany;
    }

    public String getEntrustName() {
        return entrustName;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getComponentName() {
        return componentName;
    }

    public String getComponentNumber() {
        return componentNumber;
    }

    public String getDetectionTime() {
        return detectionTime;
    }

    public String getPouringDate() {
        return pouringDate;
    }

    public String getDesignGrade() {
        return designGrade;
    }

    public String getComponentStrength() {
        return componentStrength;
    }

    public String getAreaTotal() {
        return areaTotal;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public String getReboundData() {
        return reboundData;
    }

    public String getTestAngle() {
        return testAngle;
    }

    public Integer getTestSurface() {
        return testSurface;
    }

    public Integer getSideIsdry() {
        return sideIsdry;
    }

    public Integer getSideRough() {
        return sideRough;
    }

    public String getCarbonationDepthofcomponents() {
        return carbonationDepthofcomponents;
    }

    public String getCarbonationDepthdata() {
        return carbonationDepthdata;
    }

    public Integer getAge() {
        return age;
    }

    public String getDetectionParam() {
        return detectionParam;
    }

    public String getSectionId() {
        return sectionId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public String getEntrustNumber() {
        return entrustNumber;
    }

    @JsonProperty(value = "section_id")
    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    @JsonProperty(value = "equipment_name")
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    @JsonProperty(value = "entrust_number")
    public void setEntrustNumber(String entrustNumber) {
        this.entrustNumber = entrustNumber;
    }

    @Override
    public String toString() {
        return "LabConcreteTestHammerModel{" +
                "guid='" + guid + '\'' +
                ", equipmentNumber='" + equipmentNumber + '\'' +
                ", sensorNumber='" + sensorNumber + '\'' +
                ", entrustCompnay='" + entrustCompany + '\'' +
                ", entrustName='" + entrustName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", componentName='" + componentName + '\'' +
                ", componentNumber='" + componentNumber + '\'' +
                ", detectionTime='" + detectionTime + '\'' +
                ", pouringDate='" + pouringDate + '\'' +
                ", designGrade='" + designGrade + '\'' +
                ", componentStrength='" + componentStrength + '\'' +
                ", areaTotal='" + areaTotal + '\'' +
                ", areaNo='" + areaNo + '\'' +
                ", reboundData='" + reboundData + '\'' +
                ", testAngle='" + testAngle + '\'' +
                ", testSurface=" + testSurface +
                ", sideIsDry=" + sideIsdry +
                ", sideRough=" + sideRough +
                ", carbonationDepthOfComponents='" + carbonationDepthofcomponents + '\'' +
                ", carbonationDepthData='" + carbonationDepthdata + '\'' +
                ", age=" + age +
                ", detectionParam='" + detectionParam + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", entrustNumber='" + entrustNumber + '\'' +
                '}';
    }
}
