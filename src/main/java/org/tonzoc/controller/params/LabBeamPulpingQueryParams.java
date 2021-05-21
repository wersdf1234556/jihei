package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class LabBeamPulpingQueryParams {
    @Operator(value = "eq", field = "modelNum")
    private String modelNum;

    @Operator(value = "eq", field = "guid")
    private String id;

    @Operator(value = "eq", field = "componentId")
    private String componentId;

    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }
}
