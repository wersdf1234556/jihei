package org.tonzoc.model.support;

public class ReturnProjectModel {

    private String name;
    private String amount; // 金额
    private String amountOne; // 金额1
    private String proportion; // 比例

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
}
