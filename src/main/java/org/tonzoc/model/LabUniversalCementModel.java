package org.tonzoc.model;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labUniversalCements")
public class LabUniversalCementModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "testId")
    private String testId;
    @Column(value = "groupId")
    private String groupId;
    @Column(value = "organizationId")
    private String organizationId;
    @Column(value = "sectionId")
    private String sectionId;
    @Column(value = "sectionName")
    private String sectionName;
    @Column(value = "equipmentNumber")
    private String equipmentNumber;
    @Column(value = "equipmentName")
    private String equipmentName;
    @Column(value = "testDate")
    private String testDate;
    @Column(value = "uploadTime")
    private String uploadTime;
    @Column(value = "testCount")
    private String testCount;
    @Column(value = "testCode")
    private String testCode;
    @Column(value = "operator")
    private String operator;
    @Column(value = "testType")
    private String testType;
    @Column(value = "cubeSideLength")
    private String cubeSideLength;
    @Column(value = "originalArea")
    private String originalArea;
    @Column(value = "maximumForce")
    private String maximumForce;
    @Column(value = "compressiveStrength")
    private String compressiveStrength;
    @Column(value = "timeProcess")
    private String timeProcess;
    @Column(value = "forceProcess")
    private String forceProcess;
    @Column(value = "flag")
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public LabUniversalCementModel() {
    }

    public LabUniversalCementModel(String guid, String testId, String groupId, String organizationId, String sectionId, String sectionName, String equipmentNumber, String equipmentName, String testDate, String uploadTime, String testCount, String testCode, String operator, String testType, String cubeSideLength, String originalArea, String maximumForce, String compressiveStrength, String timeProcess, String forceProcess) {
        this.guid = guid;
        this.testId = testId;
        this.groupId = groupId;
        this.organizationId = organizationId;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.equipmentNumber = equipmentNumber;
        this.equipmentName = equipmentName;
        this.testDate = testDate;
        this.uploadTime = uploadTime;
        this.testCount = testCount;
        this.testCode = testCode;
        this.operator = operator;
        this.testType = testType;
        this.cubeSideLength = cubeSideLength;
        this.originalArea = originalArea;
        this.maximumForce = maximumForce;
        this.compressiveStrength = compressiveStrength;
        this.timeProcess = timeProcess;
        this.forceProcess = forceProcess;
    }

    public String getGuid() {
        return guid;
    }

    public String getTestId() {
        return testId;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public String getTestDate() {
        return testDate;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public String getTestCount() {
        return testCount;
    }

    public String getTestCode() {
        return testCode;
    }

    public String getOperator() {
        return operator;
    }

    public String getTestType() {
        return testType;
    }

    public String getCubeSideLength() {
        return cubeSideLength;
    }

    public String getOriginalArea() {
        return originalArea;
    }

    public String getMaximumForce() {
        return maximumForce;
    }

    public String getCompressiveStrength() {
        return compressiveStrength;
    }

    public String getTimeProcess() {
        return timeProcess;
    }

    public String getForceProcess() {
        return forceProcess;
    }

    @JsonProperty(value = "guid")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty(value = "test_id")
    public void setTestId(String testId) {
        this.testId = testId;
    }

    @JsonProperty(value = "group_id")
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @JsonProperty(value = "organization_id")
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @JsonProperty(value = "section_id")
    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    @JsonProperty(value = "section_name")
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @JsonProperty(value = "equipment_number")
    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    @JsonProperty(value = "equipment_name")
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    @JsonProperty(value = "test_date")
    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    @JsonProperty(value = "upload_time")
    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    @JsonProperty(value = "operator")
    public void setOperator(String operator) {
        this.operator = operator;
    }

    @JsonProperty(value = "test_count")
    public void setTestCount(String testCount) {
        this.testCount = testCount;
    }

    @JsonProperty(value = "test_code")
    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    @JsonProperty(value = "test_type")
    public void setTestType(String testType) {
        this.testType = testType;
    }

    @JsonProperty(value = "cube_side_length")
    public void setCubeSideLength(String cubeSideLength) {
        this.cubeSideLength = cubeSideLength;
    }

    @JsonProperty(value = "original_area")
    public void setOriginalArea(String originalArea) {
        this.originalArea = originalArea;
    }

    @JsonProperty(value = "compressive_strength")
    public void setCompressiveStrength(String compressiveStrength) {
        this.compressiveStrength = compressiveStrength;
    }

    @JsonProperty(value = "maximum_force")
    public void setMaximumForce(String maximumForce) {
        this.maximumForce = maximumForce;
    }

    @JsonProperty(value = "time_process")
    public void setTimeProcess(String timeProcess) {
        this.timeProcess = timeProcess;
    }

    @JsonProperty(value = "force_process")
    public void setForceProcess(String forceProcess) {
        this.forceProcess = forceProcess;
    }
}
