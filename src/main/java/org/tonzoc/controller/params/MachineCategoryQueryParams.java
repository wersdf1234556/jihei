package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class MachineCategoryQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
