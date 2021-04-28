package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.JoinColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

import java.util.List;

@Table(value = "labBeamTensions")
public class LabBeamTensionModel extends BaseModel {
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "equipmentNumber")
    private String equipmentNumber;
    @Column(value = "engineeringName")
    private String engineeringName;
    @Column(value = "engineeringSite")
    private String engineeringSite;
    @Column(value = "componentId")
    private String componentId;
    @Column(value = "componentParts")
    private String componentParts;
    @Column(value = "beamType")
    private String beamType;
    @Column(value = "concreteStrength")
    private String concreteStrength;
    @Column(value = "elasticModulus")
    private String elasticModulus;
    @Column(value = "steelBeamNo")
    private String steelBeamNo;
    @Column(value = "steelStrand")
    private String steelStrand;
    @Column(value = "tensioningSection")
    private String tensioningSection;
    @Column(value = "tensioningDate")
    private String tensioningDate;
    @Column(value = "tensioningForce0")
    private String tensioningForce0;
    @Column(value = "tensioningForce1")
    private String tensioningForce1;
    @Column(value = "tensioningForce2")
    private String tensioningForce2;
    @Column(value = "tensioningForce3")
    private String tensioningForce3;
    @Column(value = "tensioningForce4")
    private String tensioningForce4;
    @Column(value = "elongation0")
    private String elongation0;
    @Column(value = "elongation1")
    private String elongation1;
    @Column(value = "elongation2")
    private String elongation2;
    @Column(value = "elongation3")
    private String elongation3;
    @Column(value = "elongation4")
    private String elongation4;
    @Column(value = "oilPressure0")
    private String oilPressure0;
    @Column(value = "oilPressure1")
    private String oilPressure1;
    @Column(value = "oilPressure2")
    private String oilPressure2;
    @Column(value = "oilPressure3")
    private String oilPressure3;
    @Column(value = "oilPressure4")
    private String oilPressure4;
    @Column(value = "tensionControl")
    private String tensionControl;
    @Column(value = "totalElongation")
    private String totalElongation;
    @Column(value = "theoreticalElongation")
    private String theoreticalElongation;
    @Column(value = "extendError")
    private String extendError;
    @Column(value = "forceCurve")
    private String forceCurve;
    @Column(value = "elongationCurve")
    private String elongationCurve;
    @Column(value = "oilPressureCurve")
    private String oilPressureCurve;
    @Column(value = "result")
    private String result;
    @Column(value = "userId")
    private String userId;
    @Column(value = "otherInformation")
    private String otherInformation;
    @Column(value = "forceError")
    private String forceError;
    @Column(value = "loadHoldingTime")
    private String loadHoldingTime;
    @Column(value = "retraction")
    private String retraction;
    @Column(value = "anchorWidth")
    private String anchorWidth;
    @Column(value = "birthTime")
    private String birthTime;
    @Column(value = "anchorThickness")
    private String anchorThickness;
    @Column(value = "tensionMode")
    private String tensionMode;
    @Column(value = "modelNum")
    private String modelNum;
    private String sectionId;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;
    @JoinColumn(value = "name", type = BeamPrefabricationModel.class, leftColumn = "modelNum", rightColumn = "guid")
    private String beamName;

    public String getBeamName() {
        return beamName;
    }

    public void setBeamName(String beamName) {
        this.beamName = beamName;
    }

    @Column(value = "equipmentName")
    private String equipmentName;

    private List<LabBeamTensionModel> children;

    public List<LabBeamTensionModel> getChildren() {
        return children;
    }

    public void setChildren(List<LabBeamTensionModel> children) {
        this.children = children;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    @JsonProperty(value = "equipment_name")
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getSectionId() {
        return sectionId;
    }

    @JsonProperty(value = "section_id")
    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public LabBeamTensionModel(String guid, String equipmentNumber, String engineeringName, String engineeringSite, String componentId, String componentParts, String beamType, String concreteStrength, String elasticModulus, String steelBeamNo, String steelStrand, String tensioningSection, String tensioningDate, String tensioningForce0, String tensioningForce1, String tensioningForce2, String tensioningForce3, String tensioningForce4, String elongation0, String elongation1, String elongation2, String elongation3, String elongation4, String oilPressure0, String oilPressure1, String oilPressure2, String oilPressure3, String oilPressure4, String tensionControl, String totalElongation, String theoreticalElongation, String extendError, String forceCurve, String elongationCurve, String oilPressureCurve, String result, String userId, String otherInformation, String forceError, String loadHoldingTime, String retraction, String anchorWidth, String birthTime, String anchorThickness, String tensionMode) {
        this.guid = guid;
        this.equipmentNumber = equipmentNumber;
        this.engineeringName = engineeringName;
        this.engineeringSite = engineeringSite;
        this.componentId = componentId;
        this.componentParts = componentParts;
        this.beamType = beamType;
        this.concreteStrength = concreteStrength;
        this.elasticModulus = elasticModulus;
        this.steelBeamNo = steelBeamNo;
        this.steelStrand = steelStrand;
        this.tensioningSection = tensioningSection;
        this.tensioningDate = tensioningDate;
        this.tensioningForce0 = tensioningForce0;
        this.tensioningForce1 = tensioningForce1;
        this.tensioningForce2 = tensioningForce2;
        this.tensioningForce3 = tensioningForce3;
        this.tensioningForce4 = tensioningForce4;
        this.elongation0 = elongation0;
        this.elongation1 = elongation1;
        this.elongation2 = elongation2;
        this.elongation3 = elongation3;
        this.elongation4 = elongation4;
        this.oilPressure0 = oilPressure0;
        this.oilPressure1 = oilPressure1;
        this.oilPressure2 = oilPressure2;
        this.oilPressure3 = oilPressure3;
        this.oilPressure4 = oilPressure4;
        this.tensionControl = tensionControl;
        this.totalElongation = totalElongation;
        this.theoreticalElongation = theoreticalElongation;
        this.extendError = extendError;
        this.forceCurve = forceCurve;
        this.elongationCurve = elongationCurve;
        this.oilPressureCurve = oilPressureCurve;
        this.result = result;
        this.userId = userId;
        this.otherInformation = otherInformation;
        this.forceError = forceError;
        this.loadHoldingTime = loadHoldingTime;
        this.retraction = retraction;
        this.anchorWidth = anchorWidth;
        this.birthTime = birthTime;
        this.anchorThickness = anchorThickness;
        this.tensionMode = tensionMode;
    }

    public LabBeamTensionModel() {
    }

    public String getGuid() {
        return guid;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public String getEngineeringName() {
        return engineeringName;
    }

    public String getEngineeringSite() {
        return engineeringSite;
    }

    public String getComponentId() {
        return componentId;
    }

    public String getComponentParts() {
        return componentParts;
    }

    public String getBeamType() {
        return beamType;
    }

    public String getConcreteStrength() {
        return concreteStrength;
    }

    public String getElasticModulus() {
        return elasticModulus;
    }

    public String getSteelBeamNo() {
        return steelBeamNo;
    }

    public String getSteelStrand() {
        return steelStrand;
    }

    public String getTensioningSection() {
        return tensioningSection;
    }

    public String getTensioningDate() {
        return tensioningDate;
    }

    public String getTensioningForce0() {
        return tensioningForce0;
    }

    public String getTensioningForce1() {
        return tensioningForce1;
    }

    public String getTensioningForce2() {
        return tensioningForce2;
    }

    public String getTensioningForce3() {
        return tensioningForce3;
    }

    public String getTensioningForce4() {
        return tensioningForce4;
    }

    public String getElongation0() {
        return elongation0;
    }

    public String getElongation1() {
        return elongation1;
    }

    public String getElongation2() {
        return elongation2;
    }

    public String getElongation3() {
        return elongation3;
    }

    public String getElongation4() {
        return elongation4;
    }

    public String getOilPressure0() {
        return oilPressure0;
    }

    public String getOilPressure1() {
        return oilPressure1;
    }

    public String getOilPressure2() {
        return oilPressure2;
    }

    public String getOilPressure3() {
        return oilPressure3;
    }

    public String getOilPressure4() {
        return oilPressure4;
    }

    public String getTensionControl() {
        return tensionControl;
    }

    public String getTotalElongation() {
        return totalElongation;
    }

    public String getTheoreticalElongation() {
        return theoreticalElongation;
    }

    public String getExtendError() {
        return extendError;
    }

    public String getForceCurve() {
        return forceCurve;
    }

    public String getElongationCurve() {
        return elongationCurve;
    }

    public String getOilPressureCurve() {
        return oilPressureCurve;
    }

    public String getResult() {
        return result;
    }

    public String getUserId() {
        return userId;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public String getForceError() {
        return forceError;
    }

    public String getLoadHoldingTime() {
        return loadHoldingTime;
    }

    public String getRetraction() {
        return retraction;
    }

    public String getAnchorWidth() {
        return anchorWidth;
    }

    public String getBirthTime() {
        return birthTime;
    }

    public String getAnchorThickness() {
        return anchorThickness;
    }

    public String getTensionMode() {
        return tensionMode;
    }

    @JsonProperty(value = "id")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty(value = "equipment_number")
    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    @JsonProperty(value = "engineering_name")
    public void setEngineeringName(String engineeringName) {
        this.engineeringName = engineeringName;
    }

    @JsonProperty(value = "engineering_site")
    public void setEngineeringSite(String engineeringSite) {
        this.engineeringSite = engineeringSite;
    }

    @JsonProperty(value = "component_id")
    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    @JsonProperty(value = "component_parts")
    public void setComponentParts(String componentParts) {
        this.componentParts = componentParts;
    }

    @JsonProperty(value = "beam_type")
    public void setBeamType(String beamType) {
        this.beamType = beamType;
    }

    @JsonProperty(value = "concrete_strength")
    public void setConcreteStrength(String concreteStrength) {
        this.concreteStrength = concreteStrength;
    }

    @JsonProperty(value = "elastic_modulus")
    public void setElasticModulus(String elasticModulus) {
        this.elasticModulus = elasticModulus;
    }

    @JsonProperty(value = "steel_beam_no")
    public void setSteelBeamNo(String steelBeamNo) {
        this.steelBeamNo = steelBeamNo;
    }

    @JsonProperty(value = "steel_strand")
    public void setSteelStrand(String steelStrand) {
        this.steelStrand = steelStrand;
    }

    @JsonProperty(value = "tensioning_section")
    public void setTensioningSection(String tensioningSection) {
        this.tensioningSection = tensioningSection;
    }

    @JsonProperty(value = "tensioning_date")
    public void setTensioningDate(String tensioningDate) {
        this.tensioningDate = tensioningDate;
    }

    @JsonProperty(value = "tensioning_force0")
    public void setTensioningForce0(String tensioningForce0) {
        this.tensioningForce0 = tensioningForce0;
    }

    @JsonProperty(value = "tensioning_force1")
    public void setTensioningForce1(String tensioningForce1) {
        this.tensioningForce1 = tensioningForce1;
    }

    @JsonProperty(value = "tensioning_force2")
    public void setTensioningForce2(String tensioningForce2) {
        this.tensioningForce2 = tensioningForce2;
    }

    @JsonProperty(value = "tensioning_force3")
    public void setTensioningForce3(String tensioningForce3) {
        this.tensioningForce3 = tensioningForce3;
    }

    @JsonProperty(value = "tensioning_force4")
    public void setTensioningForce4(String tensioningForce4) {
        this.tensioningForce4 = tensioningForce4;
    }

    @JsonProperty(value = "elongation0")
    public void setElongation0(String elongation0) {
        this.elongation0 = elongation0;
    }

    @JsonProperty(value = "elongation1")
    public void setElongation1(String elongation1) {
        this.elongation1 = elongation1;
    }

    @JsonProperty(value = "elongation2")
    public void setElongation2(String elongation2) {
        this.elongation2 = elongation2;
    }

    @JsonProperty(value = "elongation3")
    public void setElongation3(String elongation3) {
        this.elongation3 = elongation3;
    }

    @JsonProperty(value = "elongation4")
    public void setElongation4(String elongation4) {
        this.elongation4 = elongation4;
    }

    @JsonProperty(value = "oil_pressure0")
    public void setOilPressure0(String oilPressure0) {
        this.oilPressure0 = oilPressure0;
    }

    @JsonProperty(value = "oil_pressure1")
    public void setOilPressure1(String oilPressure1) {
        this.oilPressure1 = oilPressure1;
    }

    @JsonProperty(value = "oil_pressure2")
    public void setOilPressure2(String oilPressure2) {
        this.oilPressure2 = oilPressure2;
    }

    @JsonProperty(value = "oil_pressure3")
    public void setOilPressure3(String oilPressure3) {
        this.oilPressure3 = oilPressure3;
    }

    @JsonProperty(value = "oil_pressure4")
    public void setOilPressure4(String oilPressure4) {
        this.oilPressure4 = oilPressure4;
    }

    @JsonProperty(value = "tension_control")
    public void setTensionControl(String tensionControl) {
        this.tensionControl = tensionControl;
    }

    @JsonProperty(value = "total_elongation")
    public void setTotalElongation(String totalElongation) {
        this.totalElongation = totalElongation;
    }

    @JsonProperty(value = "theoretical_elongation")
    public void setTheoreticalElongation(String theoreticalElongation) {
        this.theoreticalElongation = theoreticalElongation;
    }

    @JsonProperty(value = "extend_error")
    public void setExtendError(String extendError) {
        this.extendError = extendError;
    }

    @JsonProperty(value = "force_curve")
    public void setForceCurve(String forceCurve) {
        this.forceCurve = forceCurve;
    }

    @JsonProperty(value = "elongation_curve")
    public void setElongationCurve(String elongationCurve) {
        this.elongationCurve = elongationCurve;
    }

    @JsonProperty(value = "oil_pressure_curve")
    public void setOilPressureCurve(String oilPressureCurve) {
        this.oilPressureCurve = oilPressureCurve;
    }

    @JsonProperty(value = "result")
    public void setResult(String result) {
        this.result = result;
    }

    @JsonProperty(value = "user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty(value = "other_information")
    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    @JsonProperty(value = "force_error")
    public void setForceError(String forceError) {
        this.forceError = forceError;
    }

    @JsonProperty(value = "load_holding_time")
    public void setLoadHoldingTime(String loadHoldingTime) {
        this.loadHoldingTime = loadHoldingTime;
    }

    @JsonProperty(value = "retraction")
    public void setRetraction(String retraction) {
        this.retraction = retraction;
    }

    @JsonProperty(value = "anchor_width")
    public void setAnchorWidth(String anchorWidth) {
        this.anchorWidth = anchorWidth;
    }

    @JsonProperty(value = "birth_time")
    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime;
    }

    @JsonProperty(value = "anchor_thickness")
    public void setAnchorThickness(String anchorThickness) {
        this.anchorThickness = anchorThickness;
    }

    @JsonProperty(value = "tension_mode")
    public void setTensionMode(String tensionMode) {
        this.tensionMode = tensionMode;
    }
}
