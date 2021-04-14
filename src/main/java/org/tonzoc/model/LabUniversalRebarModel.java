package org.tonzoc.model;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labUniversalRebars")
public class LabUniversalRebarModel extends BaseModel {

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
    @Column(value = "rebarNumber")
    private String rebarNumber;
    @Column(value = "operator")
    private String operator;
    @Column(value = "testCount")
    private String testCount;
    @Column(value = "testCode")
    private String testCode;
    @Column(value = "testType")
    private String testType;
    @Column(value = "nominalDiameter")
    private String nominalDiameter;
    @Column(value = "nominalSectionalArea")
    private String nominalSectionalArea;
    @Column(value = "maximumForce")
    private String maximumForce;
    @Column(value = "upperYield")
    private String upperYield;
    @Column(value = "lowerYield")
    private String lowerYield;
    @Column(value = "upperYieldStrength")
    private String upperYieldStrength;
    @Column(value = "lowerYieldStrength")
    private String lowerYieldStrength;
    @Column(value = "bendingStrength")
    private String bendingStrength;
    @Column(value = "elongationPctAfter")
    private String elongationPctAfter;
    @Column(value = "maximumTotalElongation")
    private String maximumTotalElongation;
    @Column(value = "timeProcess")
    private String timeProcess;
    @Column(value = "displacementProcess")
    private String displacementProcess;
    @Column(value = "forceProcess")
    private String forceProcess;
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

    public LabUniversalRebarModel() {
    }

    public LabUniversalRebarModel(String guid, String testId, String groupId, String organizationId, String sectionId, String sectionName, String equipmentNumber, String equipmentName, String testDate, String uploadTime, String rebarNumber, String operator, String testCount, String testCode, String testType, String nominalDiameter, String nominalSectionalArea, String maximumForce, String upperYield, String lowerYield, String upperYieldStrength, String lowerYieldStrength, String bendingStrength, String elongationPctAfter, String maximumTotalElongation, String timeProcess, String displacementProcess, String forceProcess) {
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
        this.rebarNumber = rebarNumber;
        this.operator = operator;
        this.testCount = testCount;
        this.testCode = testCode;
        this.testType = testType;
        this.nominalDiameter = nominalDiameter;
        this.nominalSectionalArea = nominalSectionalArea;
        this.maximumForce = maximumForce;
        this.upperYield = upperYield;
        this.lowerYield = lowerYield;
        this.upperYieldStrength = upperYieldStrength;
        this.lowerYieldStrength = lowerYieldStrength;
        this.bendingStrength = bendingStrength;
        this.elongationPctAfter = elongationPctAfter;
        this.maximumTotalElongation = maximumTotalElongation;
        this.timeProcess = timeProcess;
        this.displacementProcess = displacementProcess;
        this.forceProcess = forceProcess;
    }

    @Override
    public String toString() {
        return "LabUniversalRebarModel{" +
                "guid='" + guid + '\'' +
                ", testId='" + testId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", equipmentNumber='" + equipmentNumber + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", testDate='" + testDate + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", rebarNumber='" + rebarNumber + '\'' +
                ", operator='" + operator + '\'' +
                ", testCount='" + testCount + '\'' +
                ", testCode='" + testCode + '\'' +
                ", testType='" + testType + '\'' +
                ", nominalDiameter='" + nominalDiameter + '\'' +
                ", nominalSectionalArea='" + nominalSectionalArea + '\'' +
                ", maximumForce='" + maximumForce + '\'' +
                ", upperYield='" + upperYield + '\'' +
                ", lowerYield='" + lowerYield + '\'' +
                ", upperYieldStrength='" + upperYieldStrength + '\'' +
                ", lowerYieldStrength='" + lowerYieldStrength + '\'' +
                ", bendingStrength='" + bendingStrength + '\'' +
                ", elongationPctAfter='" + elongationPctAfter + '\'' +
                ", maximumTotalElongation='" + maximumTotalElongation + '\'' +
                ", timeProcess='" + timeProcess + '\'' +
                ", displacementProcess='" + displacementProcess + '\'' +
                ", forceProcess='" + forceProcess + '\'' +
                '}';
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

    public String getRebarNumber() {
        return rebarNumber;
    }

    public String getOperator() {
        return operator;
    }

    public String getTestCount() {
        return testCount;
    }

    public String getTestCode() {
        return testCode;
    }

    public String getTestType() {
        return testType;
    }

    public String getNominalDiameter() {
        return nominalDiameter;
    }

    public String getNominalSectionalArea() {
        return nominalSectionalArea;
    }

    public String getMaximumForce() {
        return maximumForce;
    }

    public String getUpperYield() {
        return upperYield;
    }

    public String getLowerYield() {
        return lowerYield;
    }

    public String getUpperYieldStrength() {
        return upperYieldStrength;
    }

    public String getLowerYieldStrength() {
        return lowerYieldStrength;
    }

    public String getBendingStrength() {
        return bendingStrength;
    }

    public String getElongationPctAfter() {
        return elongationPctAfter;
    }

    public String getMaximumTotalElongation() {
        return maximumTotalElongation;
    }

    public String getTimeProcess() {
        return timeProcess;
    }

    public String getDisplacementProcess() {
        return displacementProcess;
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

    @JsonProperty(value = "rebar_number")
    public void setRebarNumber(String rebarNumber) {
        this.rebarNumber = rebarNumber;
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

    @JsonProperty(value = "nominal_diameter")
    public void setNominalDiameter(String nominalDiameter) {
        this.nominalDiameter = nominalDiameter;
    }

    @JsonProperty(value = "nominal_sectional_area")
    public void setNominalSectionalArea(String nominalSectionalArea) {
        this.nominalSectionalArea = nominalSectionalArea;
    }

    @JsonProperty(value = "maximum_force")
    public void setMaximumForce(String maximumForce) {
        this.maximumForce = maximumForce;
    }

    @JsonProperty(value = "upper_yield")
    public void setUpperYield(String upperYield) {
        this.upperYield = upperYield;
    }

    @JsonProperty(value = "lower_yield")
    public void setLowerYield(String lowerYield) {
        this.lowerYield = lowerYield;
    }

    @JsonProperty(value = "upper_yield_strength")
    public void setUpperYieldStrength(String upperYieldStrength) {
        this.upperYieldStrength = upperYieldStrength;
    }

    @JsonProperty(value = "lower_yield_strength")
    public void setLowerYieldStrength(String lowerYieldStrength) {
        this.lowerYieldStrength = lowerYieldStrength;
    }

    @JsonProperty(value = "bending_strength")
    public void setBendingStrength(String bendingStrength) {
        this.bendingStrength = bendingStrength;
    }

    @JsonProperty(value = "elongation_pct_after")
    public void setElongationPctAfter(String elongationPctAfter) {
        this.elongationPctAfter = elongationPctAfter;
    }

    @JsonProperty(value = "maximum_total_elongation")
    public void setMaximumTotalElongation(String maximumTotalElongation) {
        this.maximumTotalElongation = maximumTotalElongation;
    }

    @JsonProperty(value = "time_process")
    public void setTimeProcess(String timeProcess) {
        this.timeProcess = timeProcess;
    }

    @JsonProperty(value = "displacement_process")
    public void setDisplacementProcess(String displacementProcess) {
        this.displacementProcess = displacementProcess;
    }

    @JsonProperty(value = "force_process")
    public void setForceProcess(String forceProcess) {
        this.forceProcess = forceProcess;
    }
}
