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

    public ProgressWeatherModel(String guid, String date, String weather, String balance, String dayTemp, String nightTemp) {
        this.guid = guid;
        this.date = date;
        this.weather = weather;
        this.balance = balance;
        this.dayTemp = dayTemp;
        this.nightTemp = nightTemp;
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

    @Override
    public String toString() {
        return "ProgressWeatherModel{" +
                "guid='" + guid + '\'' +
                ", date='" + date + '\'' +
                ", weather='" + weather + '\'' +
                ", balance='" + balance + '\'' +
                ", dayTemp='" + dayTemp + '\'' +
                ", nightTemp='" + nightTemp + '\'' +
                '}';
    }
}
