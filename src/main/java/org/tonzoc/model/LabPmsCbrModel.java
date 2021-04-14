package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labPmsCbrs")
public class LabPmsCbrModel extends BaseModel {

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
    @Column(value = "cbr25")
    private String cbr25;
    @Column(value = "cbr50")
    private String cbr50;
    @Column(value = "load")
    private String load;
    @Column(value = "displacement1")
    private String displacement1;
    @Column(value = "displacement2")
    private String displacement2;
    @Column(value = "displacement3")
    private String displacement3;
    @Column(value = "result")
    private String result;
    @Column(value = "flag")
    private Integer flag;
    @Column(value = "tenderGuid")
    private String tenderGuid;

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public LabPmsCbrModel() {
    }

    public LabPmsCbrModel(String guid, String equipmentNumber, String equipmentName, String sectionId, String sectionName, String engineeringName, String engineeringSite, String taskNo, String testType, String testName, String testNo, String groupId, String testDate, String tester, String sampleName, String testAllFr, String testFr, String sampleNo, String startTime, String endTime, String uploadTime, String diameter, String cbr25, String cbr50, String load, String displacement1, String displacement2, String displacement3, String result) {
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
        this.cbr25 = cbr25;
        this.cbr50 = cbr50;
        this.load = load;
        this.displacement1 = displacement1;
        this.displacement2 = displacement2;
        this.displacement3 = displacement3;
        this.result = result;
    }

    @Override
    public String toString() {
        return "LabPmsCbrModel{" +
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
                ", cbr25='" + cbr25 + '\'' +
                ", cbr50='" + cbr50 + '\'' +
                ", load='" + load + '\'' +
                ", displacement1='" + displacement1 + '\'' +
                ", displacement2='" + displacement2 + '\'' +
                ", displacement3='" + displacement3 + '\'' +
                ", result='" + result + '\'' +
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

    public String getCbr25() {
        return cbr25;
    }

    public String getCbr50() {
        return cbr50;
    }

    public String getLoad() {
        return load;
    }

    public String getDisplacement1() {
        return displacement1;
    }

    public String getDisplacement2() {
        return displacement2;
    }

    public String getDisplacement3() {
        return displacement3;
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

    @JsonProperty(value = "displacement_1")
    public void setDisplacement1(String displacement1) {
        this.displacement1 = displacement1;
    }

    @JsonProperty(value = "displacement_2")
    public void setDisplacement2(String displacement2) {
        this.displacement2 = displacement2;
    }

    @JsonProperty(value = "diameter")
    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    @JsonProperty(value = "cbr25")
    public void setCbr25(String cbr25) {
        this.cbr25 = cbr25;
    }

    @JsonProperty(value = "cbr50")
    public void setCbr50(String cbr50) {
        this.cbr50 = cbr50;
    }

    @JsonProperty(value = "load")
    public void setLoad(String load) {
        this.load = load;
    }

    @JsonProperty(value = "displacement_3")
    public void setDisplacement3(String displacement3) {
        this.displacement3 = displacement3;
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
