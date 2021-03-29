package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class PersonCategoryQueryParams {
    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "like", field = "name")
    private String name;

    @Operator(value = "eq", field = "flag")
    private String flag;

    @Operator(value = "eq", field = "display")
    private String display;

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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
