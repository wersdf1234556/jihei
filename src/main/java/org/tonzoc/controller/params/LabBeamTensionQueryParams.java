package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class LabBeamTensionQueryParams {

    @Operator(value = "eq", field = "modelNum")
    private String modelNum;

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }
}
