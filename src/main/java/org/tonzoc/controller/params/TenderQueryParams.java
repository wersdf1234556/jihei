package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class TenderQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "like", field = "name")
    private String name;

    @Operator(value = "like", field = "prvorganization")
    private String prvorganization;

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
}