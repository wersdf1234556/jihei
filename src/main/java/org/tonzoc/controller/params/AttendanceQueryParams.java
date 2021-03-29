package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class AttendanceQueryParams {
    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "personGuid")
    private String personGuid; //人员guid
    @Operator(value = "like", field = "attTime")
    private String attTime;//打卡时间
    @Operator(value = "eq", field = "sign")
    private String sign; //0：闸机 1：手机端
    @Operator(value = "eq", field = "status")
    private String status;//体温是否异常 0：正常1：异常  37.3℃上为异常
    @Operator(value = "eq", field = "personsTenderGuidtenderGuidTable.personName")
    private String personName; //人员姓名
    @Operator(value = "eq", field = "personsTenderGuidtenderGuidTable.idCard")
    private String idCard;//身份证号
    @Operator(value = "eq", field = "personsTenderGuidtenderGuidTable.tenderGuid")
    private String tenderGuid;//标段guid
    @Operator(value = "eq", field = "personsTenderGuidtenderGuidTable.categoryGuid")
    private String categoryGuid;//人员类别（大类别）
    @Operator(value = "eq", field = "personsTenderGuidtenderGuidTable.personTypeGuid")
    private String personTypeGuid;//人员工种
    @Operator(value = "eq", field = "personsTenderGuidtenderGuidTable.isRisk")
    private String isRisk;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
    }

    public String getAttTime() {
        return attTime;
    }

    public void setAttTime(String attTime) {
        this.attTime = attTime;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getCategoryGuid() {
        return categoryGuid;
    }

    public void setCategoryGuid(String categoryGuid) {
        this.categoryGuid = categoryGuid;
    }

    public String getPersonTypeGuid() {
        return personTypeGuid;
    }

    public void setPersonTypeGuid(String personTypeGuid) {
        this.personTypeGuid = personTypeGuid;
    }

    public String getIsRisk() {
        return isRisk;
    }

    public void setIsRisk(String isRisk) {
        this.isRisk = isRisk;
    }
}
