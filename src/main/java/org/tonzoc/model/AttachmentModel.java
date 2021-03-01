package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;

@Table("attachments")
public class AttachmentModel extends BaseModel {

    // @NotInsertColumn
    @PrimaryKey
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
    @Column(value = "fileType")
    private String fileType;  // 文件类型
    @NotInsertColumn
    @Column(value = "createdAt")
    private Date createdAt;

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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AttachmentModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", sortId=" + sortId +
                ", qualityTraceabilityGuid='" + qualityTraceabilityGuid + '\'' +
                ", fileType=" + fileType +
                ", createdAt=" + createdAt +
                '}';
    }
}
