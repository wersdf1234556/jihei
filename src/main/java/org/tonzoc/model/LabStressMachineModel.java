package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

import javax.validation.constraints.NotEmpty;

@Table(value = "labStressMachines")
public class LabStressMachineModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @com.fasterxml.jackson.annotation.JsonProperty(value = "organization_id")
    @Column(value = "organizationId")
    private String organizationId;

    public LabStressMachineModel() {
    }

    public LabStressMachineModel(String guid, String organizationId) {
        this.guid = guid;
        this.organizationId = organizationId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        return "LabStressMachineModel{" +
                "guid='" + guid + '\'' +
                ", organizationId='" + organizationId + '\'' +
                '}';
    }
}
