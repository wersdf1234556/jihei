package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.models.auth.In;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

import java.math.BigDecimal;

@Table(value = "labBeamCranes")
public class LabBeamCraneModel extends BaseModel {
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "id")
    private String id;
    @Column(value = "timestamp")
    private Integer timestamp;
    @Column(value = "windSpeed")
    private BigDecimal windSpeed;
    @Column(value = "windLevel")
    private BigDecimal windLevel;
    @Column(value = "windState")
    private Integer windState;
    @Column(value = "mainhookCycCnt")
    private BigDecimal mainhookCycCnt;
    @Column(value = "auxhookCycCnt")
    private BigDecimal auxhookCycCnt;
    @Column(value = "mainOverloadCnt")
    private BigDecimal mainOverloadCnt;
    @Column(value = "auxOverloadCnt")
    private BigDecimal auxOverloadCnt;
    @Column(value = "lastWorkedTime")
    private Integer lastWorkedTime;
    @Column(value = "nowWorkedTime")
    private Integer nowWorkedTime;
    @Column(value = "mainWeight")
    private BigDecimal mainWeight;
    @Column(value = "mainWeightState")
    private Integer mainWeightState;
    @Column(value = "auxWeight")
    private BigDecimal auxWeight;
    @Column(value = "auxWeightState")
    private Integer auxWeightState;
    @Column(value = "mainDistance")
    private BigDecimal mainDistance;
    @Column(value = "mainDistanceState")
    private BigDecimal mainDistanceState;
    @Column(value = "auxDistance")
    private BigDecimal auxDistance;
    @Column(value = "auxDistanceState")
    private Integer auxDistanceState;
    @Column(value = "mainHeight")
    private BigDecimal mainHeight;
    @Column(value = "mainHeightState")
    private Integer mainHeightState;
    @Column(value = "mainSpeed")
    private BigDecimal mainSpeed;
    @Column(value = "mainSpeedState")
    private Integer mainSpeedState;
    @Column(value = "auxHeight")
    private BigDecimal auxHeight;
    @Column(value = "auxHeightState")
    private Integer auxHeightState;
    @Column(value = "auxSpeed")
    private BigDecimal auxSpeed;
    @Column(value = "auxSpeedState")
    private Integer auxSpeedState;
    @Column(value = "txValue")
    private BigDecimal txValue;
    @Column(value = "tyValue")
    private BigDecimal tyValue;
    @Column(value = "tzValue")
    private BigDecimal tzValue;
    @Column(value = "txyState")
    private Integer txyState;
    @Column(value = "tzState")
    private Integer tzState;
    @Column(value = "mainSign0")
    private BigDecimal mainSign0;
    @Column(value = "mainSign1")
    private BigDecimal mainSign1;
    @Column(value = "manId")
    private Integer manId;
    @Column(value = "uploadTime")
    private String uploadTime;
    @Column(value = "onlineState")
    private Integer onlineState;
    @Column(value = "mainCartSpeed")
    private BigDecimal mainCartSpeed;
    @Column(value = "auxCartSpeed")
    private BigDecimal auxCartSpeed;
    @Column(value = "girderAngle")
    private BigDecimal girderAngle;
    @Column(value = "anteriorRamusAngle")
    private BigDecimal anteriorRamusAngle;
    @Column(value = "middleBranchAngle")
    private BigDecimal middleBranchAngle;

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

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public BigDecimal getWindLevel() {
        return windLevel;
    }

    public Integer getWindState() {
        return windState;
    }

    public BigDecimal getMainhookCycCnt() {
        return mainhookCycCnt;
    }

    public BigDecimal getAuxhookCycCnt() {
        return auxhookCycCnt;
    }

    public BigDecimal getMainOverloadCnt() {
        return mainOverloadCnt;
    }

    public BigDecimal getAuxOverloadCnt() {
        return auxOverloadCnt;
    }

    public Integer getLastWorkedTime() {
        return lastWorkedTime;
    }

    public Integer getNowWorkedTime() {
        return nowWorkedTime;
    }

    public BigDecimal getMainWeight() {
        return mainWeight;
    }

    public Integer getMainWeightState() {
        return mainWeightState;
    }

    public BigDecimal getAuxWeight() {
        return auxWeight;
    }

    public Integer getAuxWeightState() {
        return auxWeightState;
    }

    public BigDecimal getMainDistance() {
        return mainDistance;
    }

    public BigDecimal getMainDistanceState() {
        return mainDistanceState;
    }

    public BigDecimal getAuxDistance() {
        return auxDistance;
    }

    public Integer getAuxDistanceState() {
        return auxDistanceState;
    }

    public BigDecimal getMainHeight() {
        return mainHeight;
    }

    public Integer getMainHeightState() {
        return mainHeightState;
    }

    public BigDecimal getMainSpeed() {
        return mainSpeed;
    }

    public Integer getMainSpeedState() {
        return mainSpeedState;
    }

    public BigDecimal getAuxHeight() {
        return auxHeight;
    }

    public Integer getAuxHeightState() {
        return auxHeightState;
    }

    public BigDecimal getAuxSpeed() {
        return auxSpeed;
    }

    public Integer getAuxSpeedState() {
        return auxSpeedState;
    }

    public BigDecimal getTxValue() {
        return txValue;
    }

    public BigDecimal getTyValue() {
        return tyValue;
    }

    public BigDecimal getTzValue() {
        return tzValue;
    }

    public Integer getTxYstate() {
        return txyState;
    }

    public Integer getTzState() {
        return tzState;
    }

    public BigDecimal getMainSign0() {
        return mainSign0;
    }

    public BigDecimal getMainSign1() {
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

    public BigDecimal getMainCartSpeed() {
        return mainCartSpeed;
    }

    public BigDecimal getAuxCartSpeed() {
        return auxCartSpeed;
    }

    public BigDecimal getGirderAngle() {
        return girderAngle;
    }

    public BigDecimal getAnteriorRamusAngle() {
        return anteriorRamusAngle;
    }

    public BigDecimal getMiddleBranchAngle() {
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
    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty(value = "wind_level")
    public void setWindLevel(BigDecimal windLevel) {
        this.windLevel = windLevel;
    }

    @JsonProperty(value = "wind_state")
    public void setWindState(Integer windState) {
        this.windState = windState;
    }

    @JsonProperty(value = "mainhook_cyc_cnt")
    public void setMainhookCycCnt(BigDecimal mainhookCycCnt) {
        this.mainhookCycCnt = mainhookCycCnt;
    }

    @JsonProperty(value = "auxhook_cyc_cnt")
    public void setAuxhookCycCnt(BigDecimal auxhookCycCnt) {
        this.auxhookCycCnt = auxhookCycCnt;
    }

    @JsonProperty(value = "main_overload_cnt")
    public void setMainOverloadCnt(BigDecimal mainOverloadCnt) {
        this.mainOverloadCnt = mainOverloadCnt;
    }

    @JsonProperty(value = "aux_overload_cnt")
    public void setAuxOverloadCnt(BigDecimal auxOverloadCnt) {
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
    public void setMainWeight(BigDecimal mainWeight) {
        this.mainWeight = mainWeight;
    }

    @JsonProperty(value = "main_weight_state")
    public void setMainWeightState(Integer mainWeightState) {
        this.mainWeightState = mainWeightState;
    }

    @JsonProperty(value = "aux_weight")
    public void setAuxWeight(BigDecimal auxWeight) {
        this.auxWeight = auxWeight;
    }

    @JsonProperty(value = "aux_weight_state")
    public void setAuxWeightState(Integer auxWeightState) {
        this.auxWeightState = auxWeightState;
    }

    @JsonProperty(value = "main_distance")
    public void setMainDistance(BigDecimal mainDistance) {
        this.mainDistance = mainDistance;
    }

    @JsonProperty(value = "main_distance_state")
    public void setMainDistanceState(BigDecimal mainDistanceState) {
        this.mainDistanceState = mainDistanceState;
    }

    @JsonProperty(value = "aux_distance")
    public void setAuxDistance(BigDecimal auxDistance) {
        this.auxDistance = auxDistance;
    }

    @JsonProperty(value = "aux_distance_state")
    public void setAuxDistanceState(Integer auxDistanceState) {
        this.auxDistanceState = auxDistanceState;
    }

    @JsonProperty(value = "main_height")
    public void setMainHeight(BigDecimal mainHeight) {
        this.mainHeight = mainHeight;
    }

    @JsonProperty(value = "main_height_state")
    public void setMainHeightState(Integer mainHeightState) {
        this.mainHeightState = mainHeightState;
    }

    @JsonProperty(value = "main_speed")
    public void setMainSpeed(BigDecimal mainSpeed) {
        this.mainSpeed = mainSpeed;
    }

    @JsonProperty(value = "main_speed_state")
    public void setMainSpeedState(Integer mainSpeedState) {
        this.mainSpeedState = mainSpeedState;
    }

    @JsonProperty(value = "aux_height")
    public void setAuxHeight(BigDecimal auxHeight) {
        this.auxHeight = auxHeight;
    }

    @JsonProperty(value = "aux_height_state")
    public void setAuxHeightState(Integer auxHeightState) {
        this.auxHeightState = auxHeightState;
    }

    @JsonProperty(value = "aux_speed")
    public void setAuxSpeed(BigDecimal auxSpeed) {
        this.auxSpeed = auxSpeed;
    }

    @JsonProperty(value = "aux_speed_state")
    public void setAuxSpeedState(Integer auxSpeedState) {
        this.auxSpeedState = auxSpeedState;
    }

    @JsonProperty(value = "tx_value")
    public void setTxValue(BigDecimal txValue) {
        this.txValue = txValue;
    }

    @JsonProperty(value = "ty_value")
    public void setTyValue(BigDecimal tyValue) {
        this.tyValue = tyValue;
    }

    @JsonProperty(value = "tz_value")
    public void setTzValue(BigDecimal tzValue) {
        this.tzValue = tzValue;
    }

    @JsonProperty(value = "txy_state")
    public void setTxYstate(Integer txyState) {
        this.txyState = txyState;
    }

    @JsonProperty(value = "tz_state")
    public void setTzState(Integer tzState) {
        this.tzState = tzState;
    }

    @JsonProperty(value = "main_sign0")
    public void setMainSign0(BigDecimal mainSign0) {
        this.mainSign0 = mainSign0;
    }

    @JsonProperty(value = "main_sign1")
    public void setMainSign1(BigDecimal mainSign1) {
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
    public void setMainCartSpeed(BigDecimal mainCartSpeed) {
        this.mainCartSpeed = mainCartSpeed;
    }

    @JsonProperty(value = "aux_cart_speed")
    public void setAuxCartSpeed(BigDecimal auxCartSpeed) {
        this.auxCartSpeed = auxCartSpeed;
    }

    @JsonProperty(value = "girder_angle")
    public void setGirderAngle(BigDecimal girderAngle) {
        this.girderAngle = girderAngle;
    }

    @JsonProperty(value = "anterior_ramus_angle")
    public void setAnteriorRamusAngle(BigDecimal anteriorRamusAngle) {
        this.anteriorRamusAngle = anteriorRamusAngle;
    }

    @JsonProperty(value = "middle_branch_angle")
    public void setMiddleBranchAngle(BigDecimal middleBranchAngle) {
        this.middleBranchAngle = middleBranchAngle;
    }
}
