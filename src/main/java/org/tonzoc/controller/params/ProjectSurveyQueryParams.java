package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class ProjectSurveyQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "typeId")
    private Integer typeId; // 类型
    @Operator(value = "eq", field = "sortId")
    private Integer sortId;
    @Operator(value = "eq", field = "projectGuid")
    private String projectGuid;
    @Operator(value = "eq", field = "industryCategoryGuid")
    private String industryCategoryGuid;
    @Operator(value = "eq", field = "managementPowerGuid")
    private String managementPowerGuid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public String getIndustryCategoryGuid() {
        return industryCategoryGuid;
    }

    public void setIndustryCategoryGuid(String industryCategoryGuid) {
        this.industryCategoryGuid = industryCategoryGuid;
    }

    public String getManagementPowerGuid() {
        return managementPowerGuid;
    }

    public void setManagementPowerGuid(String managementPowerGuid) {
        this.managementPowerGuid = managementPowerGuid;
    }
}
