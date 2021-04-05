package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labUniversalMachines")
public class LabUniversalMachineModel extends BaseModel {

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
    @Column(value = "testType")
    private String testType;
    @Column(value = "testCode")
    private String testCode;
    @Column(value = "testDate")
    private String testDate;
    @Column(value = "manufacturer")
    private String manufacturer;
    @Column(value = "steelBrand")
    private String steelBrand;
    @Column(value = "designStrength")
    private String designStrength;
    @Column(value = "conversionFactor")
    private String conversionFactor;
    @Column(value = "cubeSideLength")
    private String cubeSideLength;
    @Column(value = "parallelArea")
    private String parallelArea;
    @Column(value = "originalArea")
    private String originalArea;
    @Column(value = "circleDiameter")
    private String circleDiameter;
    @Column(value = "originalGaugeLength")
    private String originalGaugeLength;
    @Column(value = "finalGaugeLength")
    private String finalGaugeLength;
    @Column(value = "extensometerGaugeLength")
    private String extensometerGaugeLength;
    @Column(value = "tensileStrength")
    private String tensileStrength;
    @Column(value = "compressiveStrength")
    private String compressiveStrength;
    @Column(value = "tensileToYield")
    private String tensileToYield;
    @Column(value = "yieldStrengthStandard")
    private String yieldStrengthStandard;
    @Column(value = "upperYield")
    private String upperYield;
    @Column(value = "upperYieldStrength")
    private String upperYieldStrength;
    @Column(value = "lowerYield")
    private String lowerYield;
    @Column(value = "lowerYieldStrength")
    private String lowerYieldStrength;
    @Column(value = "maxLoadDisp")
    private String maxLoadDisp;
    @Column(value = "maxForce")
    private String maxForce;
    @Column(value = "plasticExtensionMf")
    private String plasticExtensionMf;
    @Column(value = "plasticExtensionPctMf")
    private String plasticExtensionPctMf;
    @Column(value = "totalExtensionMf")
    private String totalExtensionMf;
    @Column(value = "totalExtensionPctMf")
    private String totalExtensionPctMf;
    @Column(value = "elongationPctAfter")
    private String elongationPctAfter;
    @Column(value = "totalElongationAt")
    private String totalElongationAt;
    @Column(value = "totalElongationPctAt")
    private String totalElongationPctAt;
    @Column(value = "bendingStrength")
    private String bendingStrength;
    @Column(value = "elasticModulus")
    private String elasticModulus;
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

    public LabUniversalMachineModel() {
    }

    public LabUniversalMachineModel(String guid, String testId, String groupId, String organizationId, String sectionId, String sectionName, String equipmentNumber, String equipmentName, String testType, String testCode, String testDate, String manufacturer, String steelBrand, String designStrength, String conversionFactor, String cubeSideLength, String parallelArea, String originalArea, String circleDiameter, String originalGaugeLength, String finalGaugeLength, String extensometerGaugeLength, String tensileStrength, String compressiveStrength, String tensileToYield, String yieldStrengthStandard, String upperYield, String upperYieldStrength, String lowerYield, String lowerYieldStrength, String maxLoadDisp, String maxForce, String plasticExtensionMf, String plasticExtensionPctMf, String totalExtensionMf, String totalExtensionPctMf, String elongationPctAfter, String totalElongationAt, String totalElongationPctAt, String bendingStrength, String elasticModulus, String timeProcess, String forceProcess) {
        this.guid = guid;
        this.testId = testId;
        this.groupId = groupId;
        this.organizationId = organizationId;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.equipmentNumber = equipmentNumber;
        this.equipmentName = equipmentName;
        this.testType = testType;
        this.testCode = testCode;
        this.testDate = testDate;
        this.manufacturer = manufacturer;
        this.steelBrand = steelBrand;
        this.designStrength = designStrength;
        this.conversionFactor = conversionFactor;
        this.cubeSideLength = cubeSideLength;
        this.parallelArea = parallelArea;
        this.originalArea = originalArea;
        this.circleDiameter = circleDiameter;
        this.originalGaugeLength = originalGaugeLength;
        this.finalGaugeLength = finalGaugeLength;
        this.extensometerGaugeLength = extensometerGaugeLength;
        this.tensileStrength = tensileStrength;
        this.compressiveStrength = compressiveStrength;
        this.tensileToYield = tensileToYield;
        this.yieldStrengthStandard = yieldStrengthStandard;
        this.upperYield = upperYield;
        this.upperYieldStrength = upperYieldStrength;
        this.lowerYield = lowerYield;
        this.lowerYieldStrength = lowerYieldStrength;
        this.maxLoadDisp = maxLoadDisp;
        this.maxForce = maxForce;
        this.plasticExtensionMf = plasticExtensionMf;
        this.plasticExtensionPctMf = plasticExtensionPctMf;
        this.totalExtensionMf = totalExtensionMf;
        this.totalExtensionPctMf = totalExtensionPctMf;
        this.elongationPctAfter = elongationPctAfter;
        this.totalElongationAt = totalElongationAt;
        this.totalElongationPctAt = totalElongationPctAt;
        this.bendingStrength = bendingStrength;
        this.elasticModulus = elasticModulus;
        this.timeProcess = timeProcess;
        this.forceProcess = forceProcess;
    }

    @Override
    public String toString() {
        return "LabUniversalMachineModel{" +
                "guid='" + guid + '\'' +
                ", testId='" + testId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", equipmentNumber='" + equipmentNumber + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", testType='" + testType + '\'' +
                ", testCode='" + testCode + '\'' +
                ", testDate='" + testDate + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", steelBrand='" + steelBrand + '\'' +
                ", designStrength='" + designStrength + '\'' +
                ", conversionFactor='" + conversionFactor + '\'' +
                ", cubeSideLength='" + cubeSideLength + '\'' +
                ", parallelArea='" + parallelArea + '\'' +
                ", originalArea='" + originalArea + '\'' +
                ", circleDiameter='" + circleDiameter + '\'' +
                ", originalGaugeLength='" + originalGaugeLength + '\'' +
                ", finalGaugeLength='" + finalGaugeLength + '\'' +
                ", extensometerGaugeLength='" + extensometerGaugeLength + '\'' +
                ", tensileStrength='" + tensileStrength + '\'' +
                ", compressiveStrength='" + compressiveStrength + '\'' +
                ", tensileToYield='" + tensileToYield + '\'' +
                ", yieldStrengthStandard='" + yieldStrengthStandard + '\'' +
                ", upperYield='" + upperYield + '\'' +
                ", upperYieldStrength='" + upperYieldStrength + '\'' +
                ", lowerYield='" + lowerYield + '\'' +
                ", lowerYieldStrength='" + lowerYieldStrength + '\'' +
                ", maxLoadDisp='" + maxLoadDisp + '\'' +
                ", maxForce='" + maxForce + '\'' +
                ", plasticExtensionMf='" + plasticExtensionMf + '\'' +
                ", plasticExtensionPctMf='" + plasticExtensionPctMf + '\'' +
                ", totalExtensionMf='" + totalExtensionMf + '\'' +
                ", totalExtensionPctMf='" + totalExtensionPctMf + '\'' +
                ", elongationPctAfter='" + elongationPctAfter + '\'' +
                ", totalElongationAt='" + totalElongationAt + '\'' +
                ", totalElongationPctAt='" + totalElongationPctAt + '\'' +
                ", bendingStrength='" + bendingStrength + '\'' +
                ", elasticModulus='" + elasticModulus + '\'' +
                ", timeProcess='" + timeProcess + '\'' +
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

    public String getTestType() {
        return testType;
    }

    public String getTestCode() {
        return testCode;
    }

    public String getTestDate() {
        return testDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getSteelBrand() {
        return steelBrand;
    }

    public String getDesignStrength() {
        return designStrength;
    }

    public String getConversionFactor() {
        return conversionFactor;
    }

    public String getCubeSideLength() {
        return cubeSideLength;
    }

    public String getParallelArea() {
        return parallelArea;
    }

    public String getOriginalArea() {
        return originalArea;
    }

    public String getCircleDiameter() {
        return circleDiameter;
    }

    public String getOriginalGaugeLength() {
        return originalGaugeLength;
    }

    public String getFinalGaugeLength() {
        return finalGaugeLength;
    }

    public String getExtensometerGaugeLength() {
        return extensometerGaugeLength;
    }

    public String getTensileStrength() {
        return tensileStrength;
    }

    public String getCompressiveStrength() {
        return compressiveStrength;
    }

    public String getTensileToYield() {
        return tensileToYield;
    }

    public String getYieldStrengthStandard() {
        return yieldStrengthStandard;
    }

    public String getUpperYield() {
        return upperYield;
    }

    public String getUpperYieldStrength() {
        return upperYieldStrength;
    }

    public String getLowerYield() {
        return lowerYield;
    }

    public String getLowerYieldStrength() {
        return lowerYieldStrength;
    }

    public String getMaxLoadDisp() {
        return maxLoadDisp;
    }

    public String getMaxForce() {
        return maxForce;
    }

    public String getPlasticExtensionMf() {
        return plasticExtensionMf;
    }

    public String getPlasticExtensionPctMf() {
        return plasticExtensionPctMf;
    }

    public String getTotalExtensionMf() {
        return totalExtensionMf;
    }

    public String getTotalExtensionPctMf() {
        return totalExtensionPctMf;
    }

    public String getElongationPctAfter() {
        return elongationPctAfter;
    }

    public String getTotalElongationAt() {
        return totalElongationAt;
    }

    public String getTotalElongationPctAt() {
        return totalElongationPctAt;
    }

    public String getBendingStrength() {
        return bendingStrength;
    }

    public String getElasticModulus() {
        return elasticModulus;
    }

    public String getTimeProcess() {
        return timeProcess;
    }

    public String getForceProcess() {
        return forceProcess;
    }

    @JsonProperty(value = "id")
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

    @JsonProperty(value = "test_type")
    public void setTestType(String testType) {
        this.testType = testType;
    }

    @JsonProperty(value = "test_code")
    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    @JsonProperty(value = "test_date")
    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    @JsonProperty(value = "manufacturer")
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @JsonProperty(value = "steel_brand")
    public void setSteelBrand(String steelBrand) {
        this.steelBrand = steelBrand;
    }

    @JsonProperty(value = "design_strength")
    public void setDesignStrength(String designStrength) {
        this.designStrength = designStrength;
    }

    @JsonProperty(value = "conversion_factor")
    public void setConversionFactor(String conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @JsonProperty(value = "cube_side_length")
    public void setCubeSideLength(String cubeSideLength) {
        this.cubeSideLength = cubeSideLength;
    }

    @JsonProperty(value = "parallel_area")
    public void setParallelArea(String parallelArea) {
        this.parallelArea = parallelArea;
    }

    @JsonProperty(value = "original_area")
    public void setOriginalArea(String originalArea) {
        this.originalArea = originalArea;
    }

    @JsonProperty(value = "circle_diameter")
    public void setCircleDiameter(String circleDiameter) {
        this.circleDiameter = circleDiameter;
    }

    @JsonProperty(value = "original_gauge_length")
    public void setOriginalGaugeLength(String originalGaugeLength) {
        this.originalGaugeLength = originalGaugeLength;
    }

    @JsonProperty(value = "final_fauge_length")
    public void setFinalGaugeLength(String finalGaugeLength) {
        this.finalGaugeLength = finalGaugeLength;
    }

    @JsonProperty(value = "extensometer_gauge_length")
    public void setExtensometerGaugeLength(String extensometerGaugeLength) {
        this.extensometerGaugeLength = extensometerGaugeLength;
    }

    @JsonProperty(value = "tensile_strength")
    public void setTensileStrength(String tensileStrength) {
        this.tensileStrength = tensileStrength;
    }

    @JsonProperty(value = "compressive_strength")
    public void setCompressiveStrength(String compressiveStrength) {
        this.compressiveStrength = compressiveStrength;
    }

    @JsonProperty(value = "tensile_to_yield")
    public void setTensileToYield(String tensileToYield) {
        this.tensileToYield = tensileToYield;
    }

    @JsonProperty(value = "yield_strength_standard")
    public void setYieldStrengthStandard(String yieldStrengthStandard) {
        this.yieldStrengthStandard = yieldStrengthStandard;
    }

    @JsonProperty(value = "upper_yield")
    public void setUpperYield(String upperYield) {
        this.upperYield = upperYield;
    }

    @JsonProperty(value = "upper_yield_strength")
    public void setUpperYieldStrength(String upperYieldStrength) {
        this.upperYieldStrength = upperYieldStrength;
    }

    @JsonProperty(value = "lower_yield")
    public void setLowerYield(String lowerYield) {
        this.lowerYield = lowerYield;
    }

    @JsonProperty(value = "lower_yield_strength")
    public void setLowerYieldStrength(String lowerYieldStrength) {
        this.lowerYieldStrength = lowerYieldStrength;
    }

    @JsonProperty(value = "max_load_disp")
    public void setMaxLoadDisp(String maxLoadDisp) {
        this.maxLoadDisp = maxLoadDisp;
    }

    @JsonProperty(value = "max_force")
    public void setMaxForce(String maxForce) {
        this.maxForce = maxForce;
    }

    @JsonProperty(value = "plastic_extension_mf")
    public void setPlasticExtensionMf(String plasticExtensionMf) {
        this.plasticExtensionMf = plasticExtensionMf;
    }

    @JsonProperty(value = "plastic_extension_pct_mf")
    public void setPlasticExtensionPctMf(String plasticExtensionPctMf) {
        this.plasticExtensionPctMf = plasticExtensionPctMf;
    }

    @JsonProperty(value = "total_extension_mf")
    public void setTotalExtensionMf(String totalExtensionMf) {
        this.totalExtensionMf = totalExtensionMf;
    }

    @JsonProperty(value = "total_extension_pct_mf")
    public void setTotalExtensionPctMf(String totalExtensionPctMf) {
        this.totalExtensionPctMf = totalExtensionPctMf;
    }

    @JsonProperty(value = "elongation_pct_after")
    public void setElongationPctAfter(String elongationPctAfter) {
        this.elongationPctAfter = elongationPctAfter;
    }

    @JsonProperty(value = "total_elongation_at")
    public void setTotalElongationAt(String totalElongationAt) {
        this.totalElongationAt = totalElongationAt;
    }

    @JsonProperty(value = "total_elongation_pct_at")
    public void setTotalElongationPctAt(String totalElongationPctAt) {
        this.totalElongationPctAt = totalElongationPctAt;
    }

    @JsonProperty(value = "bending_strength")
    public void setBendingStrength(String bendingStrength) {
        this.bendingStrength = bendingStrength;
    }

    @JsonProperty(value = "elastic_modulus")
    public void setElasticModulus(String elasticModulus) {
        this.elasticModulus = elasticModulus;
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
