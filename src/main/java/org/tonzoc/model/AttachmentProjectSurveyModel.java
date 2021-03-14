package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

// 安全和文件关联表
@Table(value = "attachmentProjectSurveys")
public class AttachmentProjectSurveyModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "url")
    private String url; // 路径
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "projectSurveyGuid")
    private String projectSurveyGuid;

    public AttachmentProjectSurveyModel() {
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

    public String getProjectSurveyGuid() {
        return projectSurveyGuid;
    }

    public void setProjectSurveyGuid(String projectSurveyGuid) {
        this.projectSurveyGuid = projectSurveyGuid;
    }

    @Override
    public String toString() {
        return "AttachmentProjectSurveyModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", sortId=" + sortId +
                ", projectSurveyGuid='" + projectSurveyGuid + '\'' +
                '}';
    }
}
