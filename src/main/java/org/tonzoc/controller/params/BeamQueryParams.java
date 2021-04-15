package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BeamQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "beamPedestalGuid")
    private String beamPedestalGuid;
    @Operator(value = "eq", field = "beamPrefabricationGuid")
    private String beamPrefabricationGuid;
    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getBeamPedestalGuid() {
        return beamPedestalGuid;
    }

    public void setBeamPedestalGuid(String beamPedestalGuid) {
        this.beamPedestalGuid = beamPedestalGuid;
    }

    public String getBeamPrefabricationGuid() {
        return beamPrefabricationGuid;
    }

    public void setBeamPrefabricationGuid(String beamPrefabricationGuid) {
        this.beamPrefabricationGuid = beamPrefabricationGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
