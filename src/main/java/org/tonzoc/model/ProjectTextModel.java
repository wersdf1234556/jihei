package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "projectText")
public class ProjectTextModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "projectGuid")
    private String projectGuid;
    @Column(value = "typeGuid")
    private String typeGuid;
    @Column(value = "pictureGuid")
    private String pictureGuid;
    @Column(value = "content")
    private String content;
    @JoinColumn(value = "name", type = ProjectModel.class, leftColumn = "projectGuid", rightColumn = "guid")
    private String projectName;
    @JoinColumn(value = "name", type = ProjectTypeModel.class, leftColumn = "typeGuid", rightColumn = "guid")
    private String typeName;
    @JoinColumn(value = "url", type = AttachmentModel.class, leftColumn = "pictureGuid", rightColumn = "guid")
    private String pictureurl;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public String getTypeGuid() {
        return typeGuid;
    }

    public void setTypeGuid(String typeGuid) {
        this.typeGuid = typeGuid;
    }

    public String getPictureGuid() {
        return pictureGuid;
    }

    public void setPictureGuid(String pictureGuid) {
        this.pictureGuid = pictureGuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    @Override
    public String toString() {
        return "ProjectTextModel{" +
                "guid='" + guid + '\'' +
                ", projectGuid='" + projectGuid + '\'' +
                ", typeGuid='" + typeGuid + '\'' +
                ", pictureGuid='" + pictureGuid + '\'' +
                ", content='" + content + '\'' +
                ", projectName='" + projectName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", pictureurl='" + pictureurl + '\'' +
                '}';
    }
}
