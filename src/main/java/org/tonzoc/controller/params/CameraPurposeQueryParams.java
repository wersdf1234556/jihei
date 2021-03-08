package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class CameraPurposeQueryParams {
    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "like", field = "name")
    private String name;
    @Operator(value = "eq", field = "typeGuid")
    private String typeGuid;

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

    public String getTypeGuid() {
        return typeGuid;
    }

    public void setTypeGuid(String typeGuid) {
        this.typeGuid = typeGuid;
    }
}
