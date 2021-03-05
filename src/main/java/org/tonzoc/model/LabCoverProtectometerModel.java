package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labCoverProtectometers")
public class LabCoverProtectometerModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "equipmentNumber")
    private String equipmentNumber;
    @Column(value = "componentName")
    private String componentName;
    @Column(value = "projectName")
    private String projectName;
    @Column(value = "projectAddress")
    private String projectAddress;
    @Column(value = "componentType")
    private String componentType;
    @Column(value = "designStrengthGrade")
    private String designStrengthGrade;
    @Column(value = "uploadTime")
    private String uploadTime;
    @Column(value = "detectionTime")
    private String detectionTime;
    @Column(value = "designThickness")
    private Integer designThickness;
    @Column(value = "numberOfBars")
    private Integer numberOfBars;
    @Column(value = "averageThickness")
    private String averageThickness;
    @Column(value = "minThickness")
    private Integer minThickness;
    @Column(value = "maxThickness")
    private Integer maxThickness;
    @Column(value = "totalLines")
    private String totalLines;
    @Column(value = "pouringDate")
    private String pouringDate;
    @Column(value = "testMethods")
    private String testMethods;
    @Column(value = "designSpacing")
    private String designSpacing;
    @Column(value = "presetDiameter")
    private String presetDiameter;
    @Column(value = "qualifiedPoints")
    private String qualifiedPoints;
    @Column(value = "lineNumber")
    private String lineNumber;
    @Column(value = "testDirection")
    private String testDirection;
    @Column(value = "curve")
    private String curve;
    @Column(value = "thicknessDeviation")
    private String thicknessDeviation;
    @Column(value = "position")
    private String position;
    @Column(value = "diameter")
    private String diameter;
    @Column(value = "gradingResults")
    private Integer gradingResults;
    @Column(value = "sectionId")
    private String sectionId;
    @Column(value = "sectionName")
    private String sectionName;

    public LabCoverProtectometerModel() {
    }

    public LabCoverProtectometerModel(String guid, String equipmentNumber, String componentName, String projectName, String projectAddress, String componentType, String designStrengthGrade, String uploadTime, String detectionTime, Integer designThickness, Integer numberOfBars, String averageThickness, Integer minThickness, Integer maxThickness, String totalLines, String pouringDate, String testMethods, String designSpacing, String presetDiameter, String qualifiedPoints, String lineNumber, String testDirection, String curve, String thicknessDeviation, String position, String diameter, Integer gradingResults, String sectionId, String sectionName) {
        this.guid = guid;
        this.equipmentNumber = equipmentNumber;
        this.componentName = componentName;
        this.projectName = projectName;
        this.projectAddress = projectAddress;
        this.componentType = componentType;
        this.designStrengthGrade = designStrengthGrade;
        this.uploadTime = uploadTime;
        this.detectionTime = detectionTime;
        this.designThickness = designThickness;
        this.numberOfBars = numberOfBars;
        this.averageThickness = averageThickness;
        this.minThickness = minThickness;
        this.maxThickness = maxThickness;
        this.totalLines = totalLines;
        this.pouringDate = pouringDate;
        this.testMethods = testMethods;
        this.designSpacing = designSpacing;
        this.presetDiameter = presetDiameter;
        this.qualifiedPoints = qualifiedPoints;
        this.lineNumber = lineNumber;
        this.testDirection = testDirection;
        this.curve = curve;
        this.thicknessDeviation = thicknessDeviation;
        this.position = position;
        this.diameter = diameter;
        this.gradingResults = gradingResults;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
    }

    @Override
    public String toString() {
        return "LabCoverProtectometerModel{" +
                "guid='" + guid + '\'' +
                ", equipmentNumber='" + equipmentNumber + '\'' +
                ", componentName='" + componentName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectAddress='" + projectAddress + '\'' +
                ", componentType='" + componentType + '\'' +
                ", designStrengthGrade='" + designStrengthGrade + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", detectionTime='" + detectionTime + '\'' +
                ", designThickness=" + designThickness +
                ", numberOfBars=" + numberOfBars +
                ", averageThickness=" + averageThickness +
                ", minThickness=" + minThickness +
                ", maxThickness=" + maxThickness +
                ", totalLines='" + totalLines + '\'' +
                ", pouringDate='" + pouringDate + '\'' +
                ", testMethods='" + testMethods + '\'' +
                ", designSpacing='" + designSpacing + '\'' +
                ", presetDiameter='" + presetDiameter + '\'' +
                ", qualifiedPoints='" + qualifiedPoints + '\'' +
                ", lineNumber='" + lineNumber + '\'' +
                ", testDirection='" + testDirection + '\'' +
                ", curve='" + curve + '\'' +
                ", thicknessDeviation='" + thicknessDeviation + '\'' +
                ", position='" + position + '\'' +
                ", diameter='" + diameter + '\'' +
                ", gradingResults=" + gradingResults +
                ", sectionId=" + sectionId +
                ", sectionName=" + sectionName +
                '}';
    }

    public String getGuid() {
        return guid;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public String getComponentName() {
        return componentName;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public String getComponentType() {
        return componentType;
    }

    public String getDesignStrengthGrade() {
        return designStrengthGrade;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public String getDetectionTime() {
        return detectionTime;
    }

    public Integer getDesignThickness() {
        return designThickness;
    }

    public Integer getNumberOfBars() {
        return numberOfBars;
    }

    public String getAverageThickness() {
        return averageThickness;
    }

    public Integer getMinThickness() {
        return minThickness;
    }

    public Integer getMaxThickness() {
        return maxThickness;
    }

    public String getTotalLines() {
        return totalLines;
    }

    public String getPouringDate() {
        return pouringDate;
    }

    public String getTestMethods() {
        return testMethods;
    }

    public String getDesignSpacing() {
        return designSpacing;
    }

    public String getPresetDiameter() {
        return presetDiameter;
    }

    public String getQualifiedPoints() {
        return qualifiedPoints;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public String getTestDirection() {
        return testDirection;
    }

    public String getCurve() {
        return curve;
    }

    public String getThicknessDeviation() {
        return thicknessDeviation;
    }

    public String getPosition() {
        return position;
    }

    public String getDiameter() {
        return diameter;
    }

    public Integer getGradingResults() {
        return gradingResults;
    }

    @JsonProperty(value = "id")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty(value = "equipment_number")
    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    @JsonProperty(value = "component_name")
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    @JsonProperty(value = "project_name")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @JsonProperty(value = "project_address")
    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    @JsonProperty(value = "component_type")
    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    @JsonProperty(value = "design_strength_grade")
    public void setDesignStrengthGrade(String designStrengthGrade) {
        this.designStrengthGrade = designStrengthGrade;
    }

    @JsonProperty(value = "upload_time")
    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    @JsonProperty(value = "detection_time")
    public void setDetectionTime(String detectionTime) {
        this.detectionTime = detectionTime;
    }

    @JsonProperty(value = "design_thickness")
    public void setDesignThickness(Integer designThickness) {
        this.designThickness = designThickness;
    }

    @JsonProperty(value = "number_ofbars")
    public void setNumberOfBars(Integer numberOfBars) {
        this.numberOfBars = numberOfBars;
    }

    @JsonProperty(value = "average_thickness")
    public void setAverageThickness(String averageThickness) {
        this.averageThickness = averageThickness;
    }

    @JsonProperty(value = "min_thickness")
    public void setMinThickness(Integer minThickness) {
        this.minThickness = minThickness;
    }

    @JsonProperty(value = "max_thickness")
    public void setMaxThickness(Integer maxThickness) {
        this.maxThickness = maxThickness;
    }

    @JsonProperty(value = "total_lines")
    public void setTotalLines(String totalLines) {
        this.totalLines = totalLines;
    }

    @JsonProperty(value = "pouring_date")
    public void setPouringDate(String pouringDate) {
        this.pouringDate = pouringDate;
    }

    @JsonProperty(value = "test_methods")
    public void setTestMethods(String testMethods) {
        this.testMethods = testMethods;
    }

    @JsonProperty(value = "design_spacing")
    public void setDesignSpacing(String designSpacing) {
        this.designSpacing = designSpacing;
    }

    @JsonProperty(value = "preset_diameter")
    public void setPresetDiameter(String presetDiameter) {
        this.presetDiameter = presetDiameter;
    }

    @JsonProperty(value = "qualified_points")
    public void setQualifiedPoints(String qualifiedPoints) {
        this.qualifiedPoints = qualifiedPoints;
    }

    @JsonProperty(value = "line_number")
    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    @JsonProperty(value = "test_direction")
    public void setTestDirection(String testDirection) {
        this.testDirection = testDirection;
    }

    @JsonProperty(value = "curve")
    public void setCurve(String curve) {
        this.curve = curve;
    }

    @JsonProperty(value = "thickness_deviation")
    public void setThicknessDeviation(String thicknessDeviation) {
        this.thicknessDeviation = thicknessDeviation;
    }

    @JsonProperty(value = "position")
    public void setPosition(String position) {
        this.position = position;
    }

    @JsonProperty(value = "diameter")
    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }
    
    @JsonProperty(value = "gradingresults")
    public void setGradingResults(Integer gradingResults) {
        this.gradingResults = gradingResults;
    }

    public String getSectionId() {
        return sectionId;
    }

    @JsonProperty(value = "section_id")
    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    @JsonProperty(value = "section_name")
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
