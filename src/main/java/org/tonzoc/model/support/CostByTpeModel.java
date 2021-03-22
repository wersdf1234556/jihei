package org.tonzoc.model.support;

import java.math.BigDecimal;

public class CostByTpeModel {
//    private String guid;
    private String name;
    private BigDecimal totalBalance;
    private BigDecimal situationBalance;
    private String percentNum;

    public CostByTpeModel(String name, BigDecimal totalBalance, BigDecimal situationBalance, String percentNum) {
        this.name = name;
        this.totalBalance = totalBalance;
        this.situationBalance = situationBalance;
        this.percentNum = percentNum;
    }

    public CostByTpeModel() {
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

    public String getPercentNum() {
        return percentNum;
    }

    public void setPercentNum(String percentNum) {
        this.percentNum = percentNum;
    }

    @Override
    public String toString() {
        return "CostByTpeModel{" +
                "name='" + name + '\'' +
                ", totalBalance=" + totalBalance +
                ", situationBalance=" + situationBalance +
                ", percentNum=" + percentNum +
                '}';
    }
}
