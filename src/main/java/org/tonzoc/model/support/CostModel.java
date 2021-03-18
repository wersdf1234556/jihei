package org.tonzoc.model.support;

import java.math.BigDecimal;

public class CostModel {
    private BigDecimal cost;  //总投资
    private BigDecimal accumulated;  //累计投资
    private BigDecimal currentYearCost; //本年投资
    private BigDecimal currentMonthCost;//本月投资
    private String percent;   //完成率

    public CostModel(BigDecimal cost, BigDecimal accumulated, BigDecimal currentYearCost, BigDecimal currentMonthCost, String percent) {
        this.cost = cost;
        this.accumulated = accumulated;
        this.currentYearCost = currentYearCost;
        this.currentMonthCost = currentMonthCost;
        this.percent = percent;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getAccumulated() {
        return accumulated;
    }

    public void setAccumulated(BigDecimal accumulated) {
        this.accumulated = accumulated;
    }

    public BigDecimal getCurrentYearCost() {
        return currentYearCost;
    }

    public void setCurrentYearCost(BigDecimal currentYearCost) {
        this.currentYearCost = currentYearCost;
    }

    public BigDecimal getCurrentMonthCost() {
        return currentMonthCost;
    }

    public void setCurrentMonthCost(BigDecimal currentMonthCost) {
        this.currentMonthCost = currentMonthCost;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "CostModel{" +
                "cost=" + cost +
                ", accumulated=" + accumulated +
                ", currentYearCost=" + currentYearCost +
                ", currentMonthCost=" + currentMonthCost +
                ", percent=" + percent +
                '}';
    }
}
