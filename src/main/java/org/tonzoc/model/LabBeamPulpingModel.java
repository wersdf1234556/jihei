package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.*;

@Table(value = "labBeamPulpings")
public class LabBeamPulpingModel extends BaseModel {
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
    @Column(value = "pulpingOrientation")
    private String pulpingOrientation;
    @Column(value = "pulpingOrder")
    private String pulpingOrder;
    @Column(value = "flowVelocity")
    private String flowVelocity;
    @Column(value = "fluidity")
    private String fluidity;
    @Column(value = "mixProportion")
    private String mixProportion;
    @Column(value = "waterBinderRatio")
    private String waterBinderRatio;
    @Column(value = "stirringTime")
    private String stirringTime;
    @Column(value = "startDate")
    private String startDate;
    @Column(value = "endDate")
    private String endDate;
    @Column(value = "pulpingVolume")
    private String pulpingVolume;
    @Column(value = "standardVolume")
    private String standardVolume;
    @Column(value = "pulpingPressureIn")
    private String pulpingPressureIn;
    @Column(value = "pulpingPressureOut")
    private String pulpingPressureOut;
    @Column(value = "loadHoldingTime")
    private String loadHoldingTime;
    @Column(value = "volumeCurve")
    private String volumeCurve;
    @Column(value = "pressureInCurve")
    private String pressureInCurve;
    @Column(value = "pressureOutCurve")
    private String pressureOutCurve;
    @Column(value = "result")
    private String result;
    @Column(value = "userId")
    private String userId;
    @Column(value = "otherInformation")
    private String otherInformation;
    @Column(value = "holeType")
    private String holeType;
    @Column(value = "birthTime")
    private String birthTime;
    @Column(value = "pulpingMode")
    private String pulpingMode;
    @Column(value = "measureType")
    private String measureType;
    @Column(value = "modelNum")
    private String modelNum;
    @Column(value = "sectionId")
    private String sectionId;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;

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

    public LabBeamPulpingModel(String guid, String equipmentNumber, String engineeringName, String engineeringSite, String componentId, String componentParts, String beamType, String concreteStrength, String elasticModulus, String steelBeamNo, String steelStrand, String pulpingOrientation, String pulpingOrder, String flowVelocity, String fluidity, String mixProportion, String waterBinderRatio, String stirringTime, String startDate, String endDate, String pulpingVolume, String standardVolume, String pulpingPressureIn, String pulpingPressureOut, String loadHoldingTime, String volumeCurve, String pressureInCurve, String pressureOutCurve, String result, String userId, String otherInformation, String holeType, String birthTime, String pulpingMode, String measureType) {
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
        this.pulpingOrientation = pulpingOrientation;
        this.pulpingOrder = pulpingOrder;
        this.flowVelocity = flowVelocity;
        this.fluidity = fluidity;
        this.mixProportion = mixProportion;
        this.waterBinderRatio = waterBinderRatio;
        this.stirringTime = stirringTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pulpingVolume = pulpingVolume;
        this.standardVolume = standardVolume;
        this.pulpingPressureIn = pulpingPressureIn;
        this.pulpingPressureOut = pulpingPressureOut;
        this.loadHoldingTime = loadHoldingTime;
        this.volumeCurve = volumeCurve;
        this.pressureInCurve = pressureInCurve;
        this.pressureOutCurve = pressureOutCurve;
        this.result = result;
        this.userId = userId;
        this.otherInformation = otherInformation;
        this.holeType = holeType;
        this.birthTime = birthTime;
        this.pulpingMode = pulpingMode;
        this.measureType = measureType;
    }

    public LabBeamPulpingModel() {
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

    public String getPulpingOrientation() {
        return pulpingOrientation;
    }

    public String getPulpingOrder() {
        return pulpingOrder;
    }

    public String getFlowVelocity() {
        return flowVelocity;
    }

    public String getFluidity() {
        return fluidity;
    }

    public String getMixProportion() {
        return mixProportion;
    }

    public String getWaterBinderRatio() {
        return waterBinderRatio;
    }

    public String getStirringTime() {
        return stirringTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getPulpingVolume() {
        return pulpingVolume;
    }

    public String getStandardVolume() {
        return standardVolume;
    }

    public String getPulpingPressureIn() {
        return pulpingPressureIn;
    }

    public String getPulpingPressureOut() {
        return pulpingPressureOut;
    }

    public String getLoadHoldingTime() {
        return loadHoldingTime;
    }

    public String getVolumeCurve() {
        return volumeCurve;
    }

    public String getPressureInCurve() {
        return pressureInCurve;
    }

    public String getPressureOutCurve() {
        return pressureOutCurve;
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

    public String getHoleType() {
        return holeType;
    }

    public String getBirthTime() {
        return birthTime;
    }

    public String getPulpingMode() {
        return pulpingMode;
    }

    public String getMeasureType() {
        return measureType;
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

    @JsonProperty(value = "pulping_orientation")
    public void setPulpingOrientation(String pulpingOrientation) {
        this.pulpingOrientation = pulpingOrientation;
    }

    @JsonProperty(value = "pulping_order")
    public void setPulpingOrder(String pulpingOrder) {
        this.pulpingOrder = pulpingOrder;
    }

    @JsonProperty(value = "flow_velocity")
    public void setFlowVelocity(String flowVelocity) {
        this.flowVelocity = flowVelocity;
    }

    @JsonProperty(value = "fluidity")
    public void setFluidity(String fluidity) {
        this.fluidity = fluidity;
    }

    @JsonProperty(value = "mix_proportion")
    public void setMixProportion(String mixProportion) {
        this.mixProportion = mixProportion;
    }

    @JsonProperty(value = "water_binder_ratio")
    public void setWaterBinderRatio(String waterBinderRatio) {
        this.waterBinderRatio = waterBinderRatio;
    }

    @JsonProperty(value = "stirring_time")
    public void setStirringTime(String stirringTime) {
        this.stirringTime = stirringTime;
    }

    @JsonProperty(value = "start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty(value = "end_date")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty(value = "pulping_volume")
    public void setPulpingVolume(String pulpingVolume) {
        this.pulpingVolume = pulpingVolume;
    }

    @JsonProperty(value = "standard_volume")
    public void setStandardVolume(String standardVolume) {
        this.standardVolume = standardVolume;
    }

    @JsonProperty(value = "pulping_pressure_in")
    public void setPulpingPressureIn(String pulpingPressureIn) {
        this.pulpingPressureIn = pulpingPressureIn;
    }

    @JsonProperty(value = "pulping_pressure_out")
    public void setPulpingPressureOut(String pulpingPressureOut) {
        this.pulpingPressureOut = pulpingPressureOut;
    }

    @JsonProperty(value = "load_holding_time")
    public void setLoadHoldingTime(String loadHoldingTime) {
        this.loadHoldingTime = loadHoldingTime;
    }

    @JsonProperty(value = "volume_curve")
    public void setVolumeCurve(String volumeCurve) {
        this.volumeCurve = volumeCurve;
    }

    @JsonProperty(value = "pressure_in_curve")
    public void setPressureInCurve(String pressureInCurve) {
        this.pressureInCurve = pressureInCurve;
    }

    @JsonProperty(value = "pressure_out_curve")
    public void setPressureOutCurve(String pressureOutCurve) {
        this.pressureOutCurve = pressureOutCurve;
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

    @JsonProperty(value = "hole_type")
    public void setHoleType(String holeType) {
        this.holeType = holeType;
    }

    @JsonProperty(value = "birth_time")
    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime;
    }

    @JsonProperty(value = "pulping_mode")
    public void setPulpingMode(String pulpingMode) {
        this.pulpingMode = pulpingMode;
    }

    @JsonProperty(value = "measure_type")
    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }
}
