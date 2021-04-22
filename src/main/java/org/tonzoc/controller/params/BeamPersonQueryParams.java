package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BeamPersonQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "beamGuid")
    private String beamGuid;
    @Operator(value = "eq", field = "personGuid")
    private String personGuid;
    @Operator(value = "eq", field = "personTypeGuid")
    private String personTypeGuid;
    @Operator(value = "eq", field = "sortId")
    private Integer sortId;
    @Operator(value = "like", field = "attTime")
    private String attTime;
    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;
    @Operator(value = "like", field = "personsNamepersonNameTable.name")
    private String personName;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getBeamGuid() {
        return beamGuid;
    }

    public void setBeamGuid(String beamGuid) {
        this.beamGuid = beamGuid;
    }

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
    }

    public String getPersonTypeGuid() {
        return personTypeGuid;
    }

    public void setPersonTypeGuid(String personTypeGuid) {
        this.personTypeGuid = personTypeGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getAttTime() {
        return attTime;
    }

    public void setAttTime(String attTime) {
        this.attTime = attTime;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
