package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;


@Table(value = "news")
public class NewsModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "sign")
    private String sign;     //标题的唯一标识
    @JoinColumn(value = "title", type = NewsTitleModel.class, leftColumn = "sign", rightColumn = "sign")
    private String title; //栏目大标题
    @Column(value = "attachmentGuid")
    private String attachmentGuid;
    @JoinColumn(value = "url", type = AttachmentModel.class, leftColumn = "attachmentGuid", rightColumn = "guid")
    private String url; //附件路径
    @Column(value = "content")
    private String content;      //发布内容
    @Column(value = "createdAt")
    @NotInsertColumn
    private Date createdAt;  //发布时间
    @Column(value = "topflag")
    private Integer topflag;   //置顶时间
    @Column(value = "creatorGuid")
    private String creatorGuid;    //创建人员
    @JoinColumn(value = "name", type = UserModel.class, leftColumn = "creatorGuid", rightColumn = "guid")
    private String creatorName; //创建人名称
    @Column(value = "publisher")
    private String publisher; //发布人
    @Column(value = "subtitle")
    private String subtitle; //小标题
    @Column(value = "abstractContent")
    private String abstractContent; //摘要内容


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getTopflag() {
        return topflag;
    }

    public void setTopflag(Integer topflag) {
        this.topflag = topflag;
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

    public String getCreatorGuid() {
        return creatorGuid;
    }

    public void setCreatorGuid(String creatorGuid) {
        this.creatorGuid = creatorGuid;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }
}
