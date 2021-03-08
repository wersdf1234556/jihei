package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "cameraPurpose")
public class CameraPurposeModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name; // 摄像头用途
    @Column(value = "sortId")
    private Integer sortId; // 排序
    @Column(value = "typeGuid")
    private Integer typeGuid;
    @JoinColumn(value = "name", type = CameraTypeModel.class, leftColumn = "typeGuid", rightColumn = "guid")
    private String typeName; //类型

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

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getTypeGuid() {
        return typeGuid;
    }

    public void setTypeGuid(Integer typeGuid) {
        this.typeGuid = typeGuid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
