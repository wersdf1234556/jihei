package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BeamPersonGroupQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "like", field = "name")
    private String name;
    @Operator(value = "eq", field = "personGuid")
    private String personGuid;
    @Operator(value = "eq", field = "personTypeGuid")
    private String personTypeGuid;
    @Operator(value = "eq", field = "sortId")
    private Integer sortId;
    @Operator(value = "eq", field = "beamGroupGuid")
    private String beamGroupGuid;

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

    public String getBeamGroupGuid() {
        return beamGroupGuid;
    }

    public void setBeamGroupGuid(String beamGroupGuid) {
        this.beamGroupGuid = beamGroupGuid;
    }
}
