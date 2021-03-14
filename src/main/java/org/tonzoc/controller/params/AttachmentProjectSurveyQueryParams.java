package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class AttachmentProjectSurveyQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "like", field = "name")
    private String name;

    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    @Operator(value = "eq", field = "projectSurveyGuid")
    private String projectSurveyGuid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
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

    public String getProjectSurveyGuid() {
        return projectSurveyGuid;
    }

    public void setProjectSurveyGuid(String projectSurveyGuid) {
        this.projectSurveyGuid = projectSurveyGuid;
    }
}
