package org.tonzoc.model.support;

public class LabStressMachineStatModel {
    private String sectionName;
    private Integer num;

    public LabStressMachineStatModel(String sectionName, Integer num) {
        this.sectionName = sectionName;
        this.num = num;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
