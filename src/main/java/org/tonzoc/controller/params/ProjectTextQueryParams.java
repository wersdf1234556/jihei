package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class ProjectTextQueryParams {
    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "projectGuid")
    private String projectGuid;
    @Operator(value = "eq", field = "typeGuid")
    private String typeGuid;
    @Operator(value = "eq", field = "pictureGuid")
    private String pictureGuid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public String getTypeGuid() {
        return typeGuid;
    }

    public void setTypeGuid(String typeGuid) {
        this.typeGuid = typeGuid;
    }

    public String getPictureGuid() {
        return pictureGuid;
    }

    public void setPictureGuid(String pictureGuid) {
        this.pictureGuid = pictureGuid;
    }
}
