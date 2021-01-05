package org.tonzoc.model;

import org.tonzoc.annotation.*;

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
    @Column(value = "sign")
    private String sign;     //标题的唯一标识

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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
