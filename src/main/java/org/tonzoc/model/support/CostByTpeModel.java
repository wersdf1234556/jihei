package org.tonzoc.model.support;

import java.math.BigDecimal;

public class CostByTpeModel {
//    private String guid;
    private String name;
    private BigDecimal totalBalance;
    private BigDecimal situationBalance;
    private BigDecimal percent;

    public CostByTpeModel(String name, BigDecimal totalBalance, BigDecimal situationBalance, BigDecimal percent) {
        this.name = name;
        this.totalBalance = totalBalance;
        this.situationBalance = situationBalance;
        this.percent = percent;
    }
    //    public String getGuid() {
//        return guid;
//    }
//
//    public void setGuid(String guid) {
//        this.guid = guid;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public BigDecimal getSituationBalance() {
        return situationBalance;
    }

    public void setSituationBalance(BigDecimal situationBalance) {
        this.situationBalance = situationBalance;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "CostByTpeModel{" +
                ", name='" + name + '\'' +
                ", totalBalance=" + totalBalance +
                ", situationBalance=" + situationBalance +
                ", percent=" + percent +
                '}';
    }
}
