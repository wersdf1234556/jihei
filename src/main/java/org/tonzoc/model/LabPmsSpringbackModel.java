package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labPmsSpringbacks")
public class LabPmsSpringbackModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "equipmentNumber")
    private String equipmentNumber;
    @Column(value = "equipmentName")
    private String equipmentName;
    @Column(value = "sectionId")
    private String sectionId;
    @Column(value = "sectionName")
    private String sectionName;
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
    @Column(value = "diameter")
    private String diameter;
    @Column(value = "serialNumber")
    private String serialNumber;
    @Column(value = "pressure")
    private String pressure;
    @Column(value = "pressureForce")
    private String pressureForce;
    @Column(value = "leftLoad")
    private String leftLoad;
    @Column(value = "rightLoad")
    private String rightLoad;
    @Column(value = "averageLoad")
    private String averageLoad;
    @Column(value = "leftUnload")
    private String leftUnload;
    @Column(value = "rightUnload")
    private String rightUnload;
    @Column(value = "averageUnload")
    private String averageUnload;
    @Column(value = "reboundDeformation")
    private String reboundDeformation;
    @Column(value = "reboundModulus")
    private String reboundModulus;
    @Column(value = "result")
    private String result;
    @Column(value = "flag")
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public LabPmsSpringbackModel() {
    }

    @Override
    public String toString() {
        return "LabPmsSpringbackModel{" +
                "guid='" + guid + '\'' +
                ", equipmentNumber='" + equipmentNumber + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", sectionName='" + sectionName + '\'' +
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
                ", diameter='" + diameter + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", pressure='" + pressure + '\'' +
                ", pressureForce='" + pressureForce + '\'' +
                ", leftLoad='" + leftLoad + '\'' +
                ", rightLoad='" + rightLoad + '\'' +
                ", averageLoad='" + averageLoad + '\'' +
                ", leftUnload='" + leftUnload + '\'' +
                ", rightUnload='" + rightUnload + '\'' +
                ", averageUnload='" + averageUnload + '\'' +
                ", reboundDeformation='" + reboundDeformation + '\'' +
                ", reboundModulus='" + reboundModulus + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public LabPmsSpringbackModel(String guid, String equipmentNumber, String equipmentName, String sectionId, String sectionName, String engineeringName, String engineeringSite, String taskNo, String testType, String testName, String testNo, String groupId, String testDate, String tester, String sampleName, String testAllFr, String testFr, String sampleNo, String startTime, String endTime, String uploadTime, String diameter, String serialNumber, String pressure, String pressureForce, String leftLoad, String rightLoad, String averageLoad, String leftUnload, String rightUnload, String averageUnload, String reboundDeformation, String reboundModulus, String result) {
        this.guid = guid;
        this.equipmentNumber = equipmentNumber;
        this.equipmentName = equipmentName;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
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
        this.diameter = diameter;
        this.serialNumber = serialNumber;
        this.pressure = pressure;
        this.pressureForce = pressureForce;
        this.leftLoad = leftLoad;
        this.rightLoad = rightLoad;
        this.averageLoad = averageLoad;
        this.leftUnload = leftUnload;
        this.rightUnload = rightUnload;
        this.averageUnload = averageUnload;
        this.reboundDeformation = reboundDeformation;
        this.reboundModulus = reboundModulus;
        this.result = result;
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

    public String getSectionName() {
        return sectionName;
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

    public String getDiameter() {
        return diameter;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getPressure() {
        return pressure;
    }

    public String getPressureForce() {
        return pressureForce;
    }

    public String getLeftLoad() {
        return leftLoad;
    }

    public String getRightLoad() {
        return rightLoad;
    }

    public String getAverageLoad() {
        return averageLoad;
    }

    public String getLeftUnload() {
        return leftUnload;
    }

    public String getRightUnload() {
        return rightUnload;
    }

    public String getAverageUnload() {
        return averageUnload;
    }

    public String getReboundDeformation() {
        return reboundDeformation;
    }

    public String getReboundModulus() {
        return reboundModulus;
    }

    public String getResult() {
        return result;
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

    @JsonProperty(value = "sampleName")
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

    @JsonProperty(value = "diameter")
    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    @JsonProperty(value = "serial_number")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @JsonProperty(value = "pressure")
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    @JsonProperty(value = "pressure_force")
    public void setPressureForce(String pressureForce) {
        this.pressureForce = pressureForce;
    }

    @JsonProperty(value = "left_load")
    public void setLeftLoad(String leftLoad) {
        this.leftLoad = leftLoad;
    }

    @JsonProperty(value = "right_load")
    public void setRightLoad(String rightLoad) {
        this.rightLoad = rightLoad;
    }

    @JsonProperty(value = "average_load")
    public void setAverageLoad(String averageLoad) {
        this.averageLoad = averageLoad;
    }

    @JsonProperty(value = "left_unload")
    public void setLeftUnload(String leftUnload) {
        this.leftUnload = leftUnload;
    }

    @JsonProperty(value = "right_unload")
    public void setRightUnload(String rightUnload) {
        this.rightUnload = rightUnload;
    }

    @JsonProperty(value = "average_unload")
    public void setAverageUnload(String averageUnload) {
        this.averageUnload = averageUnload;
    }

    @JsonProperty(value = "rebound_deformation")
    public void setReboundDeformation(String reboundDeformation) {
        this.reboundDeformation = reboundDeformation;
    }

    @JsonProperty(value = "rebound_modulus")
    public void setReboundModulus(String reboundModulus) {
        this.reboundModulus = reboundModulus;
    }

    @JsonProperty(value = "result")
    public void setResult(String result) {
        this.result = result;
    }

    public String getSectionId() {
        return sectionId;
    }

    @JsonProperty(value = "section_id")
    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    @JsonProperty(value = "section_name")
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
