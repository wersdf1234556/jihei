package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BuildingSafetyQueryParams {
    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "like", field = "name")
    private String name;
    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;

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
}
