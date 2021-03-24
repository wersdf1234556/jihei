package org.tonzoc.model.support;

public class ReturnProjectModel {

    private String name;
    private String amount; // 金额
    private String amounts; // 亿元
    private String amountOne; // 金额1
    private String amountOnes; // 亿元1
    private String proportion; // 比例
    private String proportions; // 比例亿元
    private Integer sortId;

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public ReturnProjectModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmountOne() {
        return amountOne;
    }

    public void setAmountOne(String amountOne) {
        this.amountOne = amountOne;
    }

    public String getAmounts() {
        return amounts;
    }

    public void setAmounts(String amounts) {
        this.amounts = amounts;
    }

    public String getAmountOnes() {
        return amountOnes;
    }

    public void setAmountOnes(String amountOnes) {
        this.amountOnes = amountOnes;
    }

    public String getProportions() {
        return proportions;
    }

    public void setProportions(String proportions) {
        this.proportions = proportions;
    }

    @Override
    public String toString() {
        return "ReturnProjectModel{" +
                "name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", amounts='" + amounts + '\'' +
                ", amountOne='" + amountOne + '\'' +
                ", amountOnes='" + amountOnes + '\'' +
                ", proportion='" + proportion + '\'' +
                ", proportions='" + proportions + '\'' +
                ", sortId=" + sortId +
                '}';
    }
}
