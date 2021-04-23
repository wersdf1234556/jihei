package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class LabBeamPulpingQueryParams {
    @Operator(value = "eq", field = "modelNum")
    private String modelNum;

    @Operator(value = "eq", field = "guid")
    private String id;

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
