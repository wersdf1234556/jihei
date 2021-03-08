package org.tonzoc.model;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labDuctilities")
public class LabDuctilityModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "equipmentNumber")
    private String equipmentNumber;
    @Column(value = "equipmentName")
    private String equipmentName;
    @Column(value = "engineeringName")
    private String engineeringName;
    @Column(value = "engineeringSite")
    private String engineeringSite;
    @Column(value = "taskNo")
    private String taskNo;
    @Column(value = "testType")
    private String testType;
    @Column(value = "testName")
    private String testName;
    @Column(value = "testNo")
    private String testNo;
    @Column(value = "groupId")
    private String groupId;
    @Column(value = "testDate")
    private String testDate;
    @Column(value = "tester")
    private String tester;
    @Column(value = "sampleName")
    private String sampleName;
    @Column(value = "testAllFr")
    private String testAllFr;
    @Column(value = "testFr")
    private String testFr;
    @Column(value = "sampleNo")
    private String sampleNo;
    @Column(value = "startTime")
    private String startTime;
    @Column(value = "endTime")
    private String endTime;
    @Column(value = "uploadTime")
    private String uploadTime;
    @Column(value = "testTemp")
    private String testTemp;
    @Column(value = "extensionSpeed")
    private String extensionSpeed;
    @Column(value = "ductility")
    private String ductility;
    @Column(value = "averageDuctility")
    private String averageDuctility;
    @Column(value = "curve")
    private String curve;
    @Column(value = "curve1")
    private String curve1;
    @Column(value = "result")
    private String result;
    @Column(value = "otherInformation")
    private String otherInformation;

    public LabDuctilityModel() {
    }

    public LabDuctilityModel(String guid, String equipmentNumber, String equipmentName, String engineeringName, String engineeringSite, String taskNo, String testType, String testName, String testNo, String groupId, String testDate, String tester, String sampleName, String testAllFr, String testFr, String sampleNo, String startTime, String endTime, String uploadTime, String testTemp, String extensionSpeed, String ductility, String averageDuctility, String curve, String curve1, String result, String otherInformation) {
        this.guid = guid;
        this.equipmentNumber = equipmentNumber;
        this.equipmentName = equipmentName;
        this.engineeringName = engineeringName;
        this.engineeringSite = engineeringSite;
        this.taskNo = taskNo;
        this.testType = testType;
        this.testName = testName;
        this.testNo = testNo;
        this.groupId = groupId;
        this.testDate = testDate;
        this.tester = tester;
        this.sampleName = sampleName;
        this.testAllFr = testAllFr;
        this.testFr = testFr;
        this.sampleNo = sampleNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.uploadTime = uploadTime;
        this.testTemp = testTemp;
        this.extensionSpeed = extensionSpeed;
        this.ductility = ductility;
        this.averageDuctility = averageDuctility;
        this.curve = curve;
        this.curve1 = curve1;
        this.result = result;
        this.otherInformation = otherInformation;
    }

    @Override
    public String toString() {
        return "LabDuctilityModel{" +
                "guid='" + guid + '\'' +
                ", equipmentNumber='" + equipmentNumber + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", engineeringName='" + engineeringName + '\'' +
                ", engineeringSite='" + engineeringSite + '\'' +
                ", taskNo='" + taskNo + '\'' +
                ", testType='" + testType + '\'' +
                ", testName='" + testName + '\'' +
                ", testNo='" + testNo + '\'' +
                ", groupId='" + groupId + '\'' +
                ", testDate='" + testDate + '\'' +
                ", tester='" + tester + '\'' +
                ", sampleName='" + sampleName + '\'' +
                ", testAllFr='" + testAllFr + '\'' +
                ", testFr='" + testFr + '\'' +
                ", sampleNo='" + sampleNo + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", testTemp='" + testTemp + '\'' +
                ", extensionSpeed='" + extensionSpeed + '\'' +
                ", ductility='" + ductility + '\'' +
                ", averageDuctility='" + averageDuctility + '\'' +
                ", curve='" + curve + '\'' +
                ", curve1='" + curve1 + '\'' +
                ", result='" + result + '\'' +
                ", otherInformation='" + otherInformation + '\'' +
                '}';
    }

    public String getGuid() {
        return guid;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public String getEngineeringName() {
        return engineeringName;
    }

    public String getEngineeringSite() {
        return engineeringSite;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public String getTestType() {
        return testType;
    }

    public String getTestName() {
        return testName;
    }

    public String getTestNo() {
        return testNo;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getTestDate() {
        return testDate;
    }

    public String getTester() {
        return tester;
    }

    public String getSampleName() {
        return sampleName;
    }

    public String getTestAllFr() {
        return testAllFr;
    }

    public String getTestFr() {
        return testFr;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public String getTestTemp() {
        return testTemp;
    }

    public String getExtensionSpeed() {
        return extensionSpeed;
    }

    public String getDuctility() {
        return ductility;
    }

    public String getAverageDuctility() {
        return averageDuctility;
    }

    public String getCurve() {
        return curve;
    }

    public String getCurve1() {
        return curve1;
    }

    public String getResult() {
        return result;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    @JsonProperty(value = "id")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty(value = "equipment_number")
    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    @JsonProperty(value = "equipment_name")
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    @JsonProperty(value = "engineering_name")
    public void setEngineeringName(String engineeringName) {
        this.engineeringName = engineeringName;
    }

    @JsonProperty(value = "engineering_site")
    public void setEngineeringSite(String engineeringSite) {
        this.engineeringSite = engineeringSite;
    }

    @JsonProperty(value = "task_no")
    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    @JsonProperty(value = "test_type")
    public void setTestType(String testType) {
        this.testType = testType;
    }

    @JsonProperty(value = "test_name")
    public void setTestName(String testName) {
        this.testName = testName;
    }

    @JsonProperty(value = "test_no")
    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    @JsonProperty(value = "group_id")
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @JsonProperty(value = "test_date")
    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    @JsonProperty(value = "tester")
    public void setTester(String tester) {
        this.tester = tester;
    }

    @JsonProperty(value = "sample_name")
    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    @JsonProperty(value = "test_all_fr")
    public void setTestAllFr(String testAllFr) {
        this.testAllFr = testAllFr;
    }

    @JsonProperty(value = "test_fr")
    public void setTestFr(String testFr) {
        this.testFr = testFr;
    }

    @JsonProperty(value = "sample_no")
    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    @JsonProperty(value = "start_time")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonProperty(value = "end_time")
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @JsonProperty(value = "upload_time")
    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    @JsonProperty(value = "test_temp")
    public void setTestTemp(String testTemp) {
        this.testTemp = testTemp;
    }

    @JsonProperty(value = "extension_speed")
    public void setExtensionSpeed(String extensionSpeed) {
        this.extensionSpeed = extensionSpeed;
    }

    @JsonProperty(value = "ductility")
    public void setDuctility(String ductility) {
        this.ductility = ductility;
    }

    @JsonProperty(value = "average_ductility")
    public void setAverageDuctility(String averageDuctility) {
        this.averageDuctility = averageDuctility;
    }

    @JsonProperty(value = "curve")
    public void setCurve(String curve) {
        this.curve = curve;
    }

    @JsonProperty(value = "curve_1")
    public void setCurve1(String curve1) {
        this.curve1 = curve1;
    }

    @JsonProperty(value = "result")
    public void setResult(String result) {
        this.result = result;
    }

    @JsonProperty(value = "other_information")
    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
}
