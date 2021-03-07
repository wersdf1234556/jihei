package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class TenderQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "like", field = "name")
    private String name;

    @Operator(value = "like", field = "prvorganization")
    private String prvorganization;

    @Operator(value = "like", field = "organization")
    private String organization;

    @Operator(value = "or", field = "guid")
    private String tenderManage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPrvorganization() {
        return prvorganization;
    }

    public void setPrvorganization(String prvorganization) {
        this.prvorganization = prvorganization;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getTenderManage() {
        return tenderManage;
    }

    public void setTenderManage(String tenderManage) {
        this.tenderManage = tenderManage;
    }
}