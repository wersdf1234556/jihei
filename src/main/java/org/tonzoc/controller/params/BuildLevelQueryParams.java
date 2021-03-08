package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BuildLevelQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "name")
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
