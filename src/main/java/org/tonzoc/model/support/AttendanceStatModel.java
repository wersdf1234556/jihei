package org.tonzoc.model.support;

public class AttendanceStatModel {

    private String typeName;
    private String total;  //总数
    private String enterNum;// 进场数
    private String attNum;//考勤数
    private String percent; //进场占总人数百分比

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAttNum() {
        return attNum;
    }

    public void setAttNum(String attNum) {
        this.attNum = attNum;
    }

    public String getEnterNum() {
        return enterNum;
    }

    public void setEnterNum(String enterNum) {
        this.enterNum = enterNum;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}
