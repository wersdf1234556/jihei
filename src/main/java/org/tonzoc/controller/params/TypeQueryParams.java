package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class TypeQueryParams {

    @Operator(value = "eq", field = "guid")
    private Integer guid;

    @Operator(value = "like", field = "name")
    private String name;

    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    public Integer getGuid() {
        return guid;
    }

    public void setGuid(Integer guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
