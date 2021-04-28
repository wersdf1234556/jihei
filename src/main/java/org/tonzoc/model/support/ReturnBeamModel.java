package org.tonzoc.model.support;

import org.tonzoc.model.BeamPrefabricationModel;

public class ReturnBeamModel extends BeamPrefabricationModel {

    private String modelNum;
    private String textNum;
    private String pedestalNum;
    private String pedestalName;
    
    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public String getTextNum() {
        return textNum;
    }

    public void setTextNum(String textNum) {
        this.textNum = textNum;
    }

    public String getPedestalNum() {
        return pedestalNum;
    }

    public void setPedestalNum(String pedestalNum) {
        this.pedestalNum = pedestalNum;
    }

    public String getPedestalName() {
        return pedestalName;
    }

    public void setPedestalName(String pedestalName) {
        this.pedestalName = pedestalName;
    }
}
