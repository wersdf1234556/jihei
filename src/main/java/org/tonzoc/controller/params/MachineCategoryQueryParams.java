package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class MachineCategoryQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
