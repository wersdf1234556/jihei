package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class ProjectQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "like", field = "name")
    private String name;
    @Operator(value = "eq", field = "isImportant")
    private Integer isImportant;
    @Operator(value = "eq", field = "industryCategoryGuid")
    private String industryCategoryGuid;
    @Operator(value = "eq", field = "managementPowerGuid")
    private String managementPowerGuid;
    @Operator(value = "eq", field = "buildLevelGuid")
    private String buildLevelGuid;
    @Operator(value = "eq", field = "projectStateGuid")
    private String projectStateGuid;
    @Operator(value = "eq", field = "isStart")
    private String isStart;
    @Operator(value = "eq", field = "hasMap")
    private Integer hasMap;

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

    public Integer getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(Integer isImportant) {
        this.isImportant = isImportant;
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

    public String getBuildLevelGuid() {
        return buildLevelGuid;
    }

    public void setBuildLevelGuid(String buildLevelGuid) {
        this.buildLevelGuid = buildLevelGuid;
    }

    public String getProjectStateGuid() {
        return projectStateGuid;
    }

    public void setProjectStateGuid(String projectStateGuid) {
        this.projectStateGuid = projectStateGuid;
    }

    public String getIsStart() {
        return isStart;
    }

    public void setIsStart(String isStart) {
        this.isStart = isStart;
    }

    public Integer getHasMap() {
        return hasMap;
    }

    public void setHasMap(Integer hasMap) {
        this.hasMap = hasMap;
    }
}
