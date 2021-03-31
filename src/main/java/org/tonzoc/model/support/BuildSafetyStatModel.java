package org.tonzoc.model.support;

import java.math.BigDecimal;

public class BuildSafetyStatModel {
    private String name;
    private String percentOne; //投资比
    private String percentTwo;//投资比

    public BuildSafetyStatModel() {
    }

    public BuildSafetyStatModel(String name, String percentOne, String percentTwo) {
        this.name = name;
        this.percentOne = percentOne;
        this.percentTwo = percentTwo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentOne() {
        return percentOne;
    }

    public void setPercentOne(String percentOne) {
        this.percentOne = percentOne;
    }

    public String getPercentTwo() {
        return percentTwo;
    }

    public void setPercentTwo(String percentTwo) {
        this.percentTwo = percentTwo;
    }

    @Override
    public String toString() {
        return "BuildSafetyStatModel{" +
                "name='" + name + '\'' +
                ", percentOne='" + percentOne + '\'' +
                ", percentTwo='" + percentTwo + '\'' +
                '}';
    }
}
