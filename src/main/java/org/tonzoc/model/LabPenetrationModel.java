package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labPenetrations")
public class LabPenetrationModel extends BaseModel {

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
    @Column(value = "upTime")
    private String upTime;
    @Column(value = "testTemp")
    private String testTemp;
    @Column(value = "penetrateTime")
    private String penetrateTime;
    @Column(value = "penetration")
    private String penetration;
    @Column(value = "average")
    private String average;
    @Column(value = "pi")
    private String pi;
    @Column(value = "curve")
    private String curve;
    @Column(value = "curve1")
    private String curve1;
    @Column(value = "result")
    private String result;
    @Column(value = "otherInformation")
    private String otherInformation;

    public LabPenetrationModel() {
    }

    public LabPenetrationModel(String guid, String equipmentNumber, String equipmentName, String engineeringName, String engineeringSite, String taskNo, String testType, String testName, String testNo, String groupId, String testDate, String tester, String sampleName, String testAllFr, String testFr, String sampleNo, String startTime, String endTime, String upTime, String testTemp, String penetrateTime, String penetration, String average, String pi, String curve, String curve1, String result, String otherInformation) {
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
        this.upTime = upTime;
        this.testTemp = testTemp;
        this.penetrateTime = penetrateTime;
        this.penetration = penetration;
        this.average = average;
        this.pi = pi;
        this.curve = curve;
        this.curve1 = curve1;
        this.result = result;
        this.otherInformation = otherInformation;
    }

    @Override
    public String toString() {
        return "LabPenetrationModel{" +
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
                ", upTime='" + upTime + '\'' +
                ", testTemp='" + testTemp + '\'' +
                ", penetrateTime='" + penetrateTime + '\'' +
                ", penetration='" + penetration + '\'' +
                ", average='" + average + '\'' +
                ", pi='" + pi + '\'' +
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

    public String getUpTime() {
        return upTime;
    }

    public String getTestTemp() {
        return testTemp;
    }

    public String getPenetrateTime() {
        return penetrateTime;
    }

    public String getPenetration() {
        return penetration;
    }

    public String getAverage() {
        return average;
    }

    public String getPi() {
        return pi;
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

    @JsonProperty(value = "up_time")
    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    @JsonProperty(value = "test_temp")
    public void setTestTemp(String testTemp) {
        this.testTemp = testTemp;
    }

    @JsonProperty(value = "penetrate_time")
    public void setPenetrateTime(String penetrateTime) {
        this.penetrateTime = penetrateTime;
    }

    @JsonProperty(value = "penetration")
    public void setPenetration(String penetration) {
        this.penetration = penetration;
    }

    @JsonProperty(value = "average")
    public void setAverage(String average) {
        this.average = average;
    }

    @JsonProperty(value = "pi")
    public void setPi(String pi) {
        this.pi = pi;
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
