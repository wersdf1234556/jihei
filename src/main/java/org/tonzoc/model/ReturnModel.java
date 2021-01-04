package org.tonzoc.model;

// 返回实体类
public class ReturnModel {

    private String name; // 名称
    private Integer number; // 数量
    private String proportion; // 比例

    public ReturnModel() {
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

    @Override
    public String toString() {
        return "ReturnModel{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", proportion='" + proportion + '\'' +
                '}';
    }
}

