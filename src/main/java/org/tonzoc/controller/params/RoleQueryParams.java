package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class RoleQueryParams {

    @Operator(value = "like", field = "name")
    private String name;

    public RoleQueryParams() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
