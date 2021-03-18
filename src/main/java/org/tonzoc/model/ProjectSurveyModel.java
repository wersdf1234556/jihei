package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table("projectSurveys")
public class ProjectSurveyModel extends BaseModel{

    @PrimaryKey
    // @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "typeId")
    private Integer typeId; // 类型
    @Column(value = "texts")
    private String texts; // 文字信息
    @Column(value = "url")
    private String url; // 路径
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "projectGuid")
    private String projectGuid;
    @Column(value = "industryCategoryGuid")
    private String industryCategoryGuid;

    @JoinColumn(value = "name", type = ProjectModel.class, leftColumn = "projectGuid", rightColumn = "guid")
    private String projectName;  // 项目名称
    @JoinColumn(value = "name", type = IndustryCategoryModel.class, leftColumn = "industryCategoryGuid", rightColumn = "guid")
    private String industryCategoryName;  // 权属名称

    public ProjectSurveyModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
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

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getIndustryCategoryGuid() {
        return industryCategoryGuid;
    }

    public void setIndustryCategoryGuid(String industryCategoryGuid) {
        this.industryCategoryGuid = industryCategoryGuid;
    }

    public String getIndustryCategoryName() {
        return industryCategoryName;
    }

    public void setIndustryCategoryName(String industryCategoryName) {
        this.industryCategoryName = industryCategoryName;
    }

    @Override
    public String toString() {
        return "ProjectSurveyModel{" +
                "guid='" + guid + '\'' +
                ", typeId=" + typeId +
                ", texts='" + texts + '\'' +
                ", url='" + url + '\'' +
                ", sortId=" + sortId +
                ", projectGuid='" + projectGuid + '\'' +
                ", industryCategoryGuid='" + industryCategoryGuid + '\'' +
                ", projectName='" + projectName + '\'' +
                ", industryCategoryName='" + industryCategoryName + '\'' +
                '}';
    }
}
