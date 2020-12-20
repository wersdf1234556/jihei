package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labPmsTesters")
public class LabPmsTesterModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "organizationId")
    private String organizationId;

    public LabPmsTesterModel() {
    }

    public LabPmsTesterModel(String guid, String organizationId) {
        this.guid = guid;
        this.organizationId = organizationId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty(value = "organizationId")
    public String getOrganizationId() {
        return organizationId;
    }

    @JsonProperty(value = "organization_id")
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        return "LabPmsTesterModel{" +
                "guid='" + guid + '\'' +
                ", organizationId='" + organizationId + '\'' +
                '}';
    }
}
