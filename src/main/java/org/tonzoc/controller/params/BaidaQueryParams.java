package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BaidaQueryParams {
    @Operator(value = "eq", field = "categoryGuid")
    private String categoryGuid;

    @Operator(value = "eq", field = "projectTypeGuid")
    private String projectTypeGuid;

    public String getCategoryGuid() {
        return categoryGuid;
    }

    public void setCategoryGuid(String categoryGuid) {
        this.categoryGuid = categoryGuid;
    }

    public String getProjectTypeGuid() {
        return projectTypeGuid;
    }

    public void setProjectTypeGuid(String projectTypeGuid) {
        this.projectTypeGuid = projectTypeGuid;
    }

    public BaidaQueryParams() {
    }
}
