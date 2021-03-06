package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class MachineTypeQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "like", field = "name")
    private String name;

    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    @Operator(value = "eq", field = "highlight")
    private Integer highlight; // 是否重点展示

    @Operator(value = "eq", field = "machineCategoryGuid")
    private String machineCategoryGuid;

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

    public Integer getHighlight() {
        return highlight;
    }

    public void setHighlight(Integer highlight) {
        this.highlight = highlight;
    }

    public String getMachineCategoryGuid() {
        return machineCategoryGuid;
    }

    public void setMachineCategoryGuid(String machineCategoryGuid) {
        this.machineCategoryGuid = machineCategoryGuid;
    }
}
