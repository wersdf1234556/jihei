package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class AuthorityQueryParams {

    @Operator(value = "like", field = "name")
    private String name;

    @Operator(value = "eq", field = "flag")
    private String flag="0";

    public AuthorityQueryParams() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
