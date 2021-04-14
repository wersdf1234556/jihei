package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labHumitures")
public class LabHumitureModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "equipmentNumber")
    private String equipmentNumber;
    @Column(value = "equipmentName")
    private String equipmentName;
    @Column(value = "sectionId")
    private String sectionId;
    @Column(value = "temperature")
    private String temperature;
    @Column(value = "humidity")
    private String humidity;
    @Column(value = "electricQuantity")
    private String electricQuantity;
    @Column(value = "dataCreationTime")
    private String dataCreationTime;
    @Column(value = "sensorName")
    private String sensorName;
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

    public LabHumitureModel() {
    }

    public LabHumitureModel(String guid, String equipmentNumber, String equipmentName, String sectionId, String temperature, String humidity, String electricQuantity, String dataCreationTime, String sensorName) {
        this.guid = guid;
        this.equipmentNumber = equipmentNumber;
        this.equipmentName = equipmentName;
        this.sectionId = sectionId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.electricQuantity = electricQuantity;
        this.dataCreationTime = dataCreationTime;
        this.sensorName = sensorName;
    }

    @Override
    public String toString() {
        return "LabHumitureModel{" +
                "guid='" + guid + '\'' +
                ", equipmentNumber='" + equipmentNumber + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", electricQuantity='" + electricQuantity + '\'' +
                ", dataCreationTime='" + dataCreationTime + '\'' +
                ", sensorName='" + sensorName + '\'' +
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

    public String getSectionId() {
        return sectionId;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getElectricQuantity() {
        return electricQuantity;
    }

    public String getDataCreationTime() {
        return dataCreationTime;
    }

    public String getSensorName() {
        return sensorName;
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

    @JsonProperty(value = "section_id")
    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    @JsonProperty(value = "temperature")
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @JsonProperty(value = "humidity")
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @JsonProperty(value = "electric_quantity")
    public void setElectricQuantity(String electricQuantity) {
        this.electricQuantity = electricQuantity;
    }

    @JsonProperty(value = "data_creation_time")
    public void setDataCreationTime(String dataCreationTime) {
        this.dataCreationTime = dataCreationTime;
    }

    @JsonProperty(value = "sensor_name")
    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
}
