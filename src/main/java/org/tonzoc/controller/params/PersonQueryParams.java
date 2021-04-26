package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class PersonQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "like", field = "name")
    private String name;
    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;
    @Operator(value = "or", field = "tenderGuid")
    private String tenderManage;
    @Operator(value = "eq", field = "categoryGuid")
    private String categoryGuid;
    @Operator(value = "eq", field = "personTypeGuid")
    private String personTypeGuid;
    @Operator(value = "like", field = "idCard")
    private String idCard;
    @Operator(value = "eq", field = "isRisk")
    private String isRisk; // 风险地区
    @Operator(value = "eq", field = "departurePlaceCode")
    private String departurePlaceCode;
    @Operator(value = "eq", field = "result")
    private String result; //0：阴性 1：阳性
    @Operator(value = "eq", field = "mobile")
    private String mobile; // 手机号
    @Operator(value = "eq", field = "enterAreaTime")
    private String enterAreaTime;
    @Operator(value = "eq", field = "isGroup")
    private Integer isGroup;


    public String getIsRisk() {
        return isRisk;
    }

    public void setIsRisk(String isRisk) {
        this.isRisk = isRisk;
    }

    public String getDeparturePlaceCode() {
        return departurePlaceCode;
    }

    public void setDeparturePlaceCode(String departurePlaceCode) {
        this.departurePlaceCode = departurePlaceCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getPersonTypeGuid() {
        return personTypeGuid;
    }

    public void setPersonTypeGuid(String personTypeGuid) {
        this.personTypeGuid = personTypeGuid;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTenderManage() {
        return tenderManage;
    }

    public void setTenderManage(String tenderManage) {
        this.tenderManage = tenderManage;
    }

    public String getCategoryGuid() {
        return categoryGuid;
    }

    public void setCategoryGuid(String categoryGuid) {
        this.categoryGuid = categoryGuid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEnterAreaTime() {
        return enterAreaTime;
    }

    public void setEnterAreaTime(String enterAreaTime) {
        this.enterAreaTime = enterAreaTime;
    }

    public Integer getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Integer isGroup) {
        this.isGroup = isGroup;
    }
}
