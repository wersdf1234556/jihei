package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table("subTypes")
public class SubTypeModel extends BaseModel {

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "typeId")
    private Integer typeId;
    @Column(value = "paragraph")
    private String paragraph; // 段落
    @Column(value = "parts")
    private String parts; // 部位
    @Column(value = "major")
    private String major; // 专业

    @JoinColumn(value = "name", type = TypeModel.class, leftColumn = "typeId", rightColumn = "id")
    private String typeName;  // 文件类型名称

    public SubTypeModel() {
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "SubTypeModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", sortId=" + sortId +
                ", typeId=" + typeId +
                ", paragraph='" + paragraph + '\'' +
                ", parts='" + parts + '\'' +
                ", major='" + major + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
