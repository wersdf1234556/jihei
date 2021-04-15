package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.JoinColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labPmsTesters")
public class LabPmsTesterModel extends BaseModel {

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
    @Column(value = "concreteAge")
    private String concreteAge;
    @Column(value = "loadValue")
    private String loadValue;
    @Column(value = "displacement1")
    private String displacement1;
    @Column(value = "displacement2")
    private String displacement2;
    @Column(value = "strength")
    private String strength;
    @Column(value = "designStrength")
    private String designStrength;
    @Column(value = "representativeStrength")
    private String representativeStrength;
    @Column(value = "strengthGraph")
    private String strengthGraph;
    @Column(value = "result")
    private String result;
    @Column(value = "sectionId")
    private String sectionId;
    @Column(value = "sectionName")
    private String sectionName;
    @Column(value = "flag")
    private Integer flag;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

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

    public LabPmsTesterModel() {
    }

    public LabPmsTesterModel(String guid, String equipmentNumber, String equipmentName, String engineeringName, String engineeringSite, String taskNo, String testType, String testName, String testNo, String groupId, String testDate, String tester, String sampleName, String testAllFr, String testFr, String sampleNo, String startTime, String endTime, String uploadTime, String concreteAge, String loadValue, String displacement1, String displacement2, String strength, String designStrength, String representativeStrength, String strengthGraph, String result, String sectionId, String sectionName) {
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
        this.concreteAge = concreteAge;
        this.loadValue = loadValue;
        this.displacement1 = displacement1;
        this.displacement2 = displacement2;
        this.strength = strength;
        this.designStrength = designStrength;
        this.representativeStrength = representativeStrength;
        this.strengthGraph = strengthGraph;
        this.result = result;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
    }

    @Override
    public String toString() {
        return "LabPmsTesterModel{" +
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
                ", concreteAge='" + concreteAge + '\'' +
                ", loadValue='" + loadValue + '\'' +
                ", displacement1='" + displacement1 + '\'' +
                ", displacement2='" + displacement2 + '\'' +
                ", strength='" + strength + '\'' +
                ", designStrength='" + designStrength + '\'' +
                ", representativeStrength='" + representativeStrength + '\'' +
                ", strengthGraph='" + strengthGraph + '\'' +
                ", result='" + result + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", sectionName='" + sectionName + '\'' +
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

    public String getConcreteAge() {
        return concreteAge;
    }

    public String getLoadValue() {
        return loadValue;
    }

    public String getDisplacement1() {
        return displacement1;
    }

    public String getDisplacement2() {
        return displacement2;
    }

    public String getStrength() {
        return strength;
    }

    public String getDesignStrength() {
        return designStrength;
    }

    public String getRepresentativeStrength() {
        return representativeStrength;
    }

    public String getStrengthGraph() {
        return strengthGraph;
    }

    public String getResult() {
        return result;
    }

    public String getSectionName() {
        return sectionName;
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

    @JsonProperty(value = "concrete_age")
    public void setConcreteAge(String concreteAge) {
        this.concreteAge = concreteAge;
    }

    @JsonProperty(value = "load_value")
    public void setLoadValue(String loadValue) {
        this.loadValue = loadValue;
    }

    @JsonProperty(value = "displacement_1")
    public void setDisplacement1(String displacement1) {
        this.displacement1 = displacement1;
    }

    @JsonProperty(value = "displacement_2")
    public void setDisplacement2(String displacement2) {
        this.displacement2 = displacement2;
    }

    @JsonProperty(value = "strength")
    public void setStrength(String strength) {
        this.strength = strength;
    }

    @JsonProperty(value = "design_strength")
    public void setDesignStrength(String designStrength) {
        this.designStrength = designStrength;
    }

    @JsonProperty(value = "representative_strength")
    public void setRepresentativeStrength(String representativeStrength) {
        this.representativeStrength = representativeStrength;
    }

    @JsonProperty(value = "strength_graph")
    public void setStrengthGraph(String strengthGraph) {
        this.strengthGraph = strengthGraph;
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
