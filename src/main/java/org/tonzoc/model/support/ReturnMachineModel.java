package org.tonzoc.model.support;

// 返回实体类
public class ReturnMachineModel {

    private String name; // 名称
    private Integer number; // 数量
    private Integer numberTotal; // 总数
    private String proportion; // 比例

    public ReturnMachineModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public Integer getNumberTotal() {
        return numberTotal;
    }

    public void setNumberTotal(Integer numberTotal) {
        this.numberTotal = numberTotal;
    }

    @Override
    public String toString() {
        return "ReturnMachineModel{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", numberTotal=" + numberTotal +
                ", proportion='" + proportion + '\'' +
                '}';
    }
}

