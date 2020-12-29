package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;


@Table(value = "news")
public class NewsModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "titleGuid")
    private String titleGuid;     //标题guid
    @JoinColumn(value = "title", type = NewsTitleModel.class, leftColumn = "titleGuid", rightColumn = "guid")
    private String title; //标题
    @Column(value = "attachmentGuid")
    private String attachmentGuid;
    @JoinColumn(value = "url", type = AttachmentModel.class, leftColumn = "attachmentGuid", rightColumn = "guid")
    private String url; //附件路径
//    @Column(value = "orgImageUrl")
//    private String orgImageUrl;  //附件路径
    @Column(value = "content")
    private String content;      //发布内容
    @Column(value = "releaseTime")
    private String releaseTime;  //发布时间
    @Column(value = "topflag")
    private Integer topflag;   //置顶时间
    @Column(value = "creator")
    private String creator;    //创建人员

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

    public String getAttachmentGuid() {
        return attachmentGuid;
    }

    public void setAttachmentGuid(String attachmentGuid) {
        this.attachmentGuid = attachmentGuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getTopflag() {
        return topflag;
    }

    public void setTopflag(Integer topflag) {
        this.topflag = topflag;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
