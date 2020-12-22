package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

import java.sql.Date;

@Table(value = "news")
public class NewsModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "titleGuid")
    private String titleGuid;
    @Column(value = "orgImageUrl")
    private String orgImageUrl;
    @Column(value = "content")
    private String content;
    @Column(value = "releaseTime")
    private Date releaseTime;
    @Column(value = "topflag")
    private Integer topflag;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitleGuid() {
        return titleGuid;
    }

    public void setTitleGuid(String titleGuid) {
        this.titleGuid = titleGuid;
    }

    public String getOrgImageUrl() {
        return orgImageUrl;
    }

    public void setOrgImageUrl(String orgImageUrl) {
        this.orgImageUrl = orgImageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getTopflag() {
        return topflag;
    }

    public void setTopflag(Integer topflag) {
        this.topflag = topflag;
    }
}
