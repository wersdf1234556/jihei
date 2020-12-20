package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class UserQueryParams {

    @Operator(value = "like", field = "name")
    private String name;

    @Operator(value = "eq", field = "projectGuid")
    private String projectGuid;


    public UserQueryParams() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }
}
