package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "progressWeathers")
public class ProgressWeatherModel extends BaseModel {
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "date")
    private String date;
    @Column(value = "weather")
    private String weather;
    @Column(value = "balance")
    private String balance;
    @Column(value = "dayTemp")
    private String dayTemp;
    @Column(value = "nightTemp")
    private String nightTemp;
    @Column(value = "warningType")
    private Integer warningType;
    @Column(value = "windPower")
    private String windPower;
    @Column(value = "averageTemp")
    private String averageTemp;

    public ProgressWeatherModel(String guid, String date, String weather, String balance, String dayTemp, String nightTemp, Integer warningType, String windPower, String averageTemp) {
        this.guid = guid;
        this.date = date;
        this.weather = weather;
        this.balance = balance;
        this.dayTemp = dayTemp;
        this.nightTemp = nightTemp;
        this.warningType = warningType;
        this.windPower = windPower;
        this.averageTemp = averageTemp;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getDayTemp() {
        return dayTemp;
    }

    public void setDayTemp(String dayTemp) {
        this.dayTemp = dayTemp;
    }

    public String getNightTemp() {
        return nightTemp;
    }

    public void setNightTemp(String nightTemp) {
        this.nightTemp = nightTemp;
    }

    public Integer getWarningType() {
        return warningType;
    }

    public void setWarningType(Integer warningType) {
        this.warningType = warningType;
    }

    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }

    public String getAverageTemp() {
        return averageTemp;
    }

    public void setAverageTemp(String averageTemp) {
        this.averageTemp = averageTemp;
    }

    @Override
    public String toString() {
        return "ProgressWeatherModel{" +
                "guid='" + guid + '\'' +
                ", date='" + date + '\'' +
                ", weather='" + weather + '\'' +
                ", balance='" + balance + '\'' +
                ", dayTemp='" + dayTemp + '\'' +
                ", nightTemp='" + nightTemp + '\'' +
                ", warningType=" + warningType +
                ", windPower='" + windPower + '\'' +
                ", averageTemp='" + averageTemp + '\'' +
                '}';
    }
}
