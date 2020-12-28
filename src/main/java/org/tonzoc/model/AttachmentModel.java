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
    @Column(value = "typeId")
    private Integer typeId;
    @Column(value = "subTypeGuid")
    private String subTypeGuid;
    @NotInsertColumn
    @Column(value = "createdAt")
    private Date createdAt;

    @JoinColumn(value = "name", type = TypeModel.class, leftColumn = "typeId", rightColumn = "id")
    private String typeName;
    @JoinColumn(value = "name", type = SubTypeModel.class, leftColumn = "subTypeGuid", rightColumn = "guid")
    private String subName;

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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getSubTypeGuid() {
        return subTypeGuid;
    }

    public void setSubTypeGuid(String subTypeGuid) {
        this.subTypeGuid = subTypeGuid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
