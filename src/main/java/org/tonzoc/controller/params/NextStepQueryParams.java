package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class NextStepQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "eq", field = "currentStepGuid")
    private String currentStepGuid;

    @Operator(value = "eq", field = "nextStepGuid")
    private String nextStepGuid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCurrentStepGuid() {
        return currentStepGuid;
    }

    public void setCurrentStepGuid(String currentStepGuid) {
        this.currentStepGuid = currentStepGuid;
    }

    public String getNextStepGuid() {
        return nextStepGuid;
    }

    public void setNextStepGuid(String nextStepGuid) {
        this.nextStepGuid = nextStepGuid;
    }
}
