package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class PersonNucleicInfoQueryParams {
    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "guid")
    private String isRisk; //是否从风险区回来
    @Operator(value = "eq", field = "personGuid")
    private String personGuid;
    @Operator(value = "eq", field = "departurePlaceGuid")
    private String departurePlaceGuid;
    @Operator(value = "eq", field = "result")
    private String result; //0：阴性 1：阳性

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getIsRisk() {
        return isRisk;
    }

    public void setIsRisk(String isRisk) {
        this.isRisk = isRisk;
    }

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
    }

    public String getDeparturePlaceGuid() {
        return departurePlaceGuid;
    }

    public void setDeparturePlaceGuid(String departurePlaceGuid) {
        this.departurePlaceGuid = departurePlaceGuid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
