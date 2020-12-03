package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class CameraTypeQueryParams {

    @Operator(value = "eq", field = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
