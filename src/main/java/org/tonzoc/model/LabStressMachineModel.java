package org.tonzoc.model;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

import javax.validation.constraints.NotEmpty;

@Table(value = "labStressMachines")
public class LabStressMachineModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
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
    @Column(value = "projectName")
    private String projectName;
    @Column(value = "constructionSpot")
    private String constructionSpot;
    @Column(value = "testType")
    private String testType;
    @Column(value = "testId")
    private String testId;
    @Column(value = "testDate")
    private String testDate;
    @Column(value = "concreteAge")
    private String concreteAge;
    @Column(value = "cubeArea")
    private String cubeArea;
    @Column(value = "cubeCode")
    private String cubeCode;
    @Column(value = "cubeCount")
    private Integer cubeCount;
    @Column(value = "representativeStrength")
    private String representativeStrength;
    @Column(value = "designStrength")
    private String designStrength;
    @Column(value = "testEvaluation")
    private Integer testEvaluation;
    @Column(value = "loadValue")
    private String loadValue;
    @Column(value = "compressiveStrength")
    private String compressiveStrength;
    @Column(value = "graphId")
    private String graphId;
    @Column(value = "processStress")
    private String processStress;
    @Column(value = "originProcessStress")
    private String originProcessStress;

    public LabStressMachineModel() {
    }

    public LabStressMachineModel(String guid, String organizationId, String sectionId, String sectionName, String equipmentNumber, String equipmentName, String projectName, String constructionSpot, String testType, String testId, String testDate, String concreteAge, String cubeArea, String cubeCode, Integer cubeCount, String representativeStrength, String designStrength, Integer testEvaluation, String loadValue, String compressiveStrength, String graphId, String processStress) {
        this.guid = guid;
        this.organizationId = organizationId;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.equipmentNumber = equipmentNumber;
        this.equipmentName = equipmentName;
        this.projectName = projectName;
        this.constructionSpot = constructionSpot;
        this.testType = testType;
        this.testId = testId;
        this.testDate = testDate;
        this.concreteAge = concreteAge;
        this.cubeArea = cubeArea;
        this.cubeCode = cubeCode;
        this.cubeCount = cubeCount;
        this.representativeStrength = representativeStrength;
        this.designStrength = designStrength;
        this.testEvaluation = testEvaluation;
        this.loadValue = loadValue;
        this.compressiveStrength = compressiveStrength;
        this.graphId = graphId;
        this.processStress = processStress;
    }

    @Override
    public String toString() {
        return "LabStressMachineModel{" +
                "guid='" + guid + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", equipmentNumber='" + equipmentNumber + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", constructionSpot='" + constructionSpot + '\'' +
                ", testType='" + testType + '\'' +
                ", testId='" + testId + '\'' +
                ", testDate='" + testDate + '\'' +
                ", concreteAge='" + concreteAge + '\'' +
                ", cubeArea='" + cubeArea + '\'' +
                ", cubeCode='" + cubeCode + '\'' +
                ", cubeCount=" + cubeCount +
                ", representativeStrength='" + representativeStrength + '\'' +
                ", designStrength='" + designStrength + '\'' +
                ", testEvaluation=" + testEvaluation +
                ", loadValue='" + loadValue + '\'' +
                ", compressiveStrength='" + compressiveStrength + '\'' +
                ", graphId='" + graphId + '\'' +
                ", processStress='" + processStress + '\'' +
                '}';
    }

    public String getGuid() {
        return guid;
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

    public String getProjectName() {
        return projectName;
    }

    public String getConstructionSpot() {
        return constructionSpot;
    }

    public String getTestType() {
        return testType;
    }

    public String getTestId() {
        return testId;
    }

    public String getTestDate() {
        return testDate;
    }

    public String getConcreteAge() {
        return concreteAge;
    }

    public String getCubeArea() {
        return cubeArea;
    }

    public String getCubeCode() {
        return cubeCode;
    }

    public Integer getCubeCount() {
        return cubeCount;
    }

    public String getRepresentativeStrength() {
        return representativeStrength;
    }

    public String getDesignStrength() {
        return designStrength;
    }

    public Integer getTestEvaluation() {
        return testEvaluation;
    }

    public String getLoadValue() {
        return loadValue;
    }

    public String getCompressiveStrength() {
        return compressiveStrength;
    }

    public String getGraphId() {
        return graphId;
    }

    public String getProcessStress() {
        return processStress;
    }

    @JsonProperty(value = "id")
    public void setGuid(String guid) {
        this.guid = guid;
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

    @JsonProperty(value = "project_name")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @JsonProperty(value = "construction_spot")
    public void setConstructionSpot(String constructSpot) {
        this.constructionSpot = constructionSpot;
    }

    @JsonProperty(value = "test_type")
    public void setTestType(String testType) {
        this.testType = testType;
    }

    @JsonProperty(value = "test_id")
    public void setTestId(String testId) {
        this.testId = testId;
    }

    @JsonProperty(value = "test_date")
    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    @JsonProperty(value = "concrete_age")
    public void setConcreteAge(String concreteAge) {
        this.concreteAge = concreteAge;
    }

    @JsonProperty(value = "cube_area")
    public void setCubeArea(String cubeArea) {
        this.cubeArea = cubeArea;
    }

    @JsonProperty(value = "cube_code")
    public void setCubeCode(String cubeCode) {
        this.cubeCode = cubeCode;
    }

    @JsonProperty(value = "cube_count")
    public void setCubeCount(Integer cubeCount) {
        this.cubeCount = cubeCount;
    }

    @JsonProperty(value = "representative_strength")
    public void setRepresentativeStrength(String representativeStrength) {
        this.representativeStrength = representativeStrength;
    }

    @JsonProperty(value = "design_strength")
    public void setDesignStrength(String designStrength) {
        this.designStrength = designStrength;
    }

    @JsonProperty(value = "test_evaluation")
    public void setTestEvaluation(Integer testEvaluation) {
        this.testEvaluation = testEvaluation;
    }

    @JsonProperty(value = "load_value")
    public void setLoadValue(String loadValue) {
        this.loadValue = loadValue;
    }

    @JsonProperty(value = "compressive_strength")
    public void setCompressiveStrength(String compressiveStrength) {
        this.compressiveStrength = compressiveStrength;
    }

    @JsonProperty(value = "graph_id")
    public void setGraphId(String graphId) {
        this.graphId = graphId;
    }

    @JsonProperty(value = "process_stress")
    public void setProcessStress(String[] processStress) {
        this.processStress = JSON.toJSONString(processStress);
        this.originProcessStress = JSON.toJSONString(processStress);
    }

    public String getOriginProcessStress() {
        return originProcessStress;
    }

    public void setOriginProcessStress(String originProcessStress) {
        this.originProcessStress = originProcessStress;
    }
}
