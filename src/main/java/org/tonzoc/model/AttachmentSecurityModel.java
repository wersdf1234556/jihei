package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 安全和文件关联表
@Table(value = "attachmentSecuritys")
public class AttachmentSecurityModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "url")
    private String url; // 路径
    @Column(value = "fileType")
    private Integer fileType; // 文件类型
    @Column(value = "securityGuid")
    private String securityGuid;
    @Column(value = "securityChangGuid")
    private String securityChangGuid;
    @Column(value = "sortId")
    private Integer sortId;

    public AttachmentSecurityModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getSecurityGuid() {
        return securityGuid;
    }

    public void setSecurityGuid(String securityGuid) {
        this.securityGuid = securityGuid;
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

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getSecurityChangGuid() {
        return securityChangGuid;
    }

    public void setSecurityChangGuid(String securityChangGuid) {
        this.securityChangGuid = securityChangGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

}
