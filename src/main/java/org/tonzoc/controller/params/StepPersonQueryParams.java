package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class StepPersonQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "eq", field = "stepGuid")
    private String stepGuid;

    @Operator(value = "eq", field = "personGuid")
    private String personGuid;

    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getStepGuid() {
        return stepGuid;
    }

    public void setStepGuid(String stepGuid) {
        this.stepGuid = stepGuid;
    }

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
