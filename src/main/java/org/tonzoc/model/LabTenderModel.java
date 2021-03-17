package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.JoinColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "labTenders")
public class LabTenderModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "mappingTenderGuid")
    private String mappingTenderGuid;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;

    public LabTenderModel() {
    }

    @Override
    public String toString() {
        return "LabTenderModel{" +
                "guid='" + guid + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", mappingTenderGuid='" + mappingTenderGuid + '\'' +
                ", tenderName='" + tenderName + '\'' +
                '}';
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getMappingTenderGuid() {
        return mappingTenderGuid;
    }

    public void setMappingTenderGuid(String mappingTenderGuid) {
        this.mappingTenderGuid = mappingTenderGuid;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }
}
