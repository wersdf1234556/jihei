package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.sql.Date;

@Table("attachments")
public class AttachmentModel extends BaseModel {

    @PrimaryKey
//    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "url")
    private String url;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "qualityTraceabilityGuid")
    private String qualityTraceabilityGuid;
    @NotInsertColumn
    @Column(value = "createdAt")
    private Date createdAt;

    @JoinColumn(value = "subTypeGuid", type = QualityTraceabilityModel.class, leftColumn = "qualityTraceabilityGuid", rightColumn = "guid")
    private String subTypeGuid;

    public AttachmentModel() {
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getQualityTraceabilityGuid() {
        return qualityTraceabilityGuid;
    }

    public void setQualityTraceabilityGuid(String qualityTraceabilityGuid) {
        this.qualityTraceabilityGuid = qualityTraceabilityGuid;
    }

    public String getSubTypeGuid() {
        return subTypeGuid;
    }

    public void setSubTypeGuid(String subTypeGuid) {
        this.subTypeGuid = subTypeGuid;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
