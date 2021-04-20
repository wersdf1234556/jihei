package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.models.auth.In;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labBeamCranes")
public class LabBeamCraneModel extends BaseModel {
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "id")
    private String id;
    @Column(value = "timestamp")
    private Integer timestamp;
    @Column(value = "windSpeed")
    private Integer windSpeed;
    @Column(value = "windLevel")
    private Integer windLevel;
    @Column(value = "windState")
    private Integer windState;
    @Column(value = "mainhookCycCnt")
    private Integer mainhookCycCnt;
    @Column(value = "auxhookCycCnt")
    private Integer auxhookCycCnt;
    @Column(value = "mainOverloadCnt")
    private Integer mainOverloadCnt;
    @Column(value = "auxOverloadCnt")
    private Integer auxOverloadCnt;
    @Column(value = "lastWorkedTime")
    private Integer lastWorkedTime;
    @Column(value = "nowWorkedTime")
    private Integer nowWorkedTime;
    @Column(value = "mainWeight")
    private Integer mainWeight;
    @Column(value = "mainWeightState")
    private Integer mainWeightState;
    @Column(value = "auxWeight")
    private Integer auxWeight;
    @Column(value = "auxWeightState")
    private Integer auxWeightState;
    @Column(value = "mainDistance")
    private Integer mainDistance;
    @Column(value = "mainDistanceState")
    private Integer mainDistanceState;
    @Column(value = "auxDistance")
    private Integer auxDistance;
    @Column(value = "auxDistanceState")
    private Integer auxDistanceState;
    @Column(value = "mainHeight")
    private Integer mainHeight;
    @Column(value = "mainHeightState")
    private Integer mainHeightState;
    @Column(value = "mainSpeed")
    private Integer mainSpeed;
    @Column(value = "mainSpeedState")
    private Integer mainSpeedState;
    @Column(value = "auxHeight")
    private Integer auxHeight;
    @Column(value = "auxHeightState")
    private Integer auxHeightState;
    @Column(value = "auxSpeed")
    private Integer auxSpeed;
    @Column(value = "auxSpeedState")
    private Integer auxSpeedState;
    @Column(value = "txValue")
    private Integer txValue;
    @Column(value = "tyValue")
    private Integer tyValue;
    @Column(value = "tzValue")
    private Integer tzValue;
    @Column(value = "txYstate")
    private Integer txYstate;
    @Column(value = "tzState")
    private Integer tzState;
    @Column(value = "mainSign0")
    private Integer mainSign0;
    @Column(value = "mainSign1")
    private Integer mainSign1;
    @Column(value = "manId")
    private Integer manId;
    @Column(value = "uploadTime")
    private String uploadTime;
    @Column(value = "onlineState")
    private Integer onlineState;
    @Column(value = "mainCartSpeed")
    private Integer mainCartSpeed;
    @Column(value = "auxCartSpeed")
    private Integer auxCartSpeed;
    @Column(value = "girderAngle")
    private Integer girderAngle;
    @Column(value = "anteriorRamusAngle")
    private Integer anteriorRamusAngle;
    @Column(value = "middleBranchAngle")
    private Integer middleBranchAngle;

    public LabBeamCraneModel() {
    }

    public String getGuid() {
        return guid;
    }

    public String getId() {
        return id;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public Integer getWindLevel() {
        return windLevel;
    }

    public Integer getWindState() {
        return windState;
    }

    public Integer getMainhookCycCnt() {
        return mainhookCycCnt;
    }

    public Integer getAuxhookCycCnt() {
        return auxhookCycCnt;
    }

    public Integer getMainOverloadCnt() {
        return mainOverloadCnt;
    }

    public Integer getAuxOverloadCnt() {
        return auxOverloadCnt;
    }

    public Integer getLastWorkedTime() {
        return lastWorkedTime;
    }

    public Integer getNowWorkedTime() {
        return nowWorkedTime;
    }

    public Integer getMainWeight() {
        return mainWeight;
    }

    public Integer getMainWeightState() {
        return mainWeightState;
    }

    public Integer getAuxWeight() {
        return auxWeight;
    }

    public Integer getAuxWeightState() {
        return auxWeightState;
    }

    public Integer getMainDistance() {
        return mainDistance;
    }

    public Integer getMainDistanceState() {
        return mainDistanceState;
    }

    public Integer getAuxDistance() {
        return auxDistance;
    }

    public Integer getAuxDistanceState() {
        return auxDistanceState;
    }

    public Integer getMainHeight() {
        return mainHeight;
    }

    public Integer getMainHeightState() {
        return mainHeightState;
    }

    public Integer getMainSpeed() {
        return mainSpeed;
    }

    public Integer getMainSpeedState() {
        return mainSpeedState;
    }

    public Integer getAuxHeight() {
        return auxHeight;
    }

    public Integer getAuxHeightState() {
        return auxHeightState;
    }

    public Integer getAuxSpeed() {
        return auxSpeed;
    }

    public Integer getAuxSpeedState() {
        return auxSpeedState;
    }

    public Integer getTxValue() {
        return txValue;
    }

    public Integer getTyValue() {
        return tyValue;
    }

    public Integer getTzValue() {
        return tzValue;
    }

    public Integer getTxYstate() {
        return txYstate;
    }

    public Integer getTzState() {
        return tzState;
    }

    public Integer getMainSign0() {
        return mainSign0;
    }

    public Integer getMainSign1() {
        return mainSign1;
    }

    public Integer getManId() {
        return manId;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public Integer getOnlineState() {
        return onlineState;
    }

    public Integer getMainCartSpeed() {
        return mainCartSpeed;
    }

    public Integer getAuxCartSpeed() {
        return auxCartSpeed;
    }

    public Integer getGirderAngle() {
        return girderAngle;
    }

    public Integer getAnteriorRamusAngle() {
        return anteriorRamusAngle;
    }

    public Integer getMiddleBranchAngle() {
        return middleBranchAngle;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty(value = "wind_speed")
    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty(value = "wind_level")
    public void setWindLevel(Integer windLevel) {
        this.windLevel = windLevel;
    }

    @JsonProperty(value = "wind_state")
    public void setWindState(Integer windState) {
        this.windState = windState;
    }

    @JsonProperty(value = "mainhook_cyc_cnt")
    public void setMainhookCycCnt(Integer mainhookCycCnt) {
        this.mainhookCycCnt = mainhookCycCnt;
    }

    @JsonProperty(value = "auxhook_cyc_cnt")
    public void setAuxhookCycCnt(Integer auxhookCycCnt) {
        this.auxhookCycCnt = auxhookCycCnt;
    }

    @JsonProperty(value = "main_overload_cnt")
    public void setMainOverloadCnt(Integer mainOverloadCnt) {
        this.mainOverloadCnt = mainOverloadCnt;
    }

    @JsonProperty(value = "aux_overload_cnt")
    public void setAuxOverloadCnt(Integer auxOverloadCnt) {
        this.auxOverloadCnt = auxOverloadCnt;
    }

    @JsonProperty(value = "last_worked_time")
    public void setLastWorkedTime(Integer lastWorkedTime) {
        this.lastWorkedTime = lastWorkedTime;
    }

    @JsonProperty(value = "now_worked_time")
    public void setNowWorkedTime(Integer nowWorkedTime) {
        this.nowWorkedTime = nowWorkedTime;
    }

    @JsonProperty(value = "main_weight")
    public void setMainWeight(Integer mainWeight) {
        this.mainWeight = mainWeight;
    }

    @JsonProperty(value = "main_weight_state")
    public void setMainWeightState(Integer mainWeightState) {
        this.mainWeightState = mainWeightState;
    }

    @JsonProperty(value = "aux_weight")
    public void setAuxWeight(Integer auxWeight) {
        this.auxWeight = auxWeight;
    }

    @JsonProperty(value = "aux_weight_state")
    public void setAuxWeightState(Integer auxWeightState) {
        this.auxWeightState = auxWeightState;
    }

    @JsonProperty(value = "main_distance")
    public void setMainDistance(Integer mainDistance) {
        this.mainDistance = mainDistance;
    }

    @JsonProperty(value = "main_distance_state")
    public void setMainDistanceState(Integer mainDistanceState) {
        this.mainDistanceState = mainDistanceState;
    }

    @JsonProperty(value = "aux_distance")
    public void setAuxDistance(Integer auxDistance) {
        this.auxDistance = auxDistance;
    }

    @JsonProperty(value = "aux_distance_state")
    public void setAuxDistanceState(Integer auxDistanceState) {
        this.auxDistanceState = auxDistanceState;
    }

    @JsonProperty(value = "main_height")
    public void setMainHeight(Integer mainHeight) {
        this.mainHeight = mainHeight;
    }

    @JsonProperty(value = "main_height_state")
    public void setMainHeightState(Integer mainHeightState) {
        this.mainHeightState = mainHeightState;
    }

    @JsonProperty(value = "main_speed")
    public void setMainSpeed(Integer mainSpeed) {
        this.mainSpeed = mainSpeed;
    }

    @JsonProperty(value = "main_speed_state")
    public void setMainSpeedState(Integer mainSpeedState) {
        this.mainSpeedState = mainSpeedState;
    }

    @JsonProperty(value = "aux_height")
    public void setAuxHeight(Integer auxHeight) {
        this.auxHeight = auxHeight;
    }

    @JsonProperty(value = "aux_height_state")
    public void setAuxHeightState(Integer auxHeightState) {
        this.auxHeightState = auxHeightState;
    }

    @JsonProperty(value = "aux_speed")
    public void setAuxSpeed(Integer auxSpeed) {
        this.auxSpeed = auxSpeed;
    }

    @JsonProperty(value = "aux_speed_state")
    public void setAuxSpeedState(Integer auxSpeedState) {
        this.auxSpeedState = auxSpeedState;
    }

    @JsonProperty(value = "tx_value")
    public void setTxValue(Integer txValue) {
        this.txValue = txValue;
    }

    @JsonProperty(value = "ty_value")
    public void setTyValue(Integer tyValue) {
        this.tyValue = tyValue;
    }

    @JsonProperty(value = "tz_value")
    public void setTzValue(Integer tzValue) {
        this.tzValue = tzValue;
    }

    @JsonProperty(value = "tx_ystate")
    public void setTxYstate(Integer txYstate) {
        this.txYstate = txYstate;
    }

    @JsonProperty(value = "tz_state")
    public void setTzState(Integer tzState) {
        this.tzState = tzState;
    }

    @JsonProperty(value = "main_sign0")
    public void setMainSign0(Integer mainSign0) {
        this.mainSign0 = mainSign0;
    }

    @JsonProperty(value = "main_sign1")
    public void setMainSign1(Integer mainSign1) {
        this.mainSign1 = mainSign1;
    }

    @JsonProperty(value = "man_id")
    public void setManId(Integer manId) {
        this.manId = manId;
    }

    @JsonProperty(value = "upload_time")
    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    @JsonProperty(value = "online_state")
    public void setOnlineState(Integer onlineState) {
        this.onlineState = onlineState;
    }

    @JsonProperty(value = "main_cart_speed")
    public void setMainCartSpeed(Integer mainCartSpeed) {
        this.mainCartSpeed = mainCartSpeed;
    }

    @JsonProperty(value = "aux_cart_speed")
    public void setAuxCartSpeed(Integer auxCartSpeed) {
        this.auxCartSpeed = auxCartSpeed;
    }

    @JsonProperty(value = "girder_angle")
    public void setGirderAngle(Integer girderAngle) {
        this.girderAngle = girderAngle;
    }

    @JsonProperty(value = "anterior_ramus_angle")
    public void setAnteriorRamusAngle(Integer anteriorRamusAngle) {
        this.anteriorRamusAngle = anteriorRamusAngle;
    }

    @JsonProperty(value = "middle_branch_angle")
    public void setMiddleBranchAngle(Integer middleBranchAngle) {
        this.middleBranchAngle = middleBranchAngle;
    }
}
