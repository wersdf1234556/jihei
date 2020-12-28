package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "newsTitles")
public class NewsTitleModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "title")
    private String title; // 名称
    @Column(value = "sortId")
    private Integer sortId;

    public NewsTitleModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    @Override
    public String toString() {
        return "NewsTitleModel{" +
                "guid='" + guid + '\'' +
                ", title='" + title + '\'' +
                ", sortId=" + sortId +
                '}';
    }

    public NewsTitleModel(String guid, String title, Integer sortId) {
        this.guid = guid;
        this.title = title;
        this.sortId = sortId;
    }
}
