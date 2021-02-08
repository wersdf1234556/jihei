package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 安全和文件关联表
@Table(value = "attachmentSecurity")
public class AttachmentSecurityModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "securityGuid")
    private String securityGuid;
    @Column(value = "inspectImgAttachment")
    private String inspectImgAttachment; // 检查图片
    @Column(value = "changeImgAttachment")
    private String changeImgAttachment; // 修正图片
    @Column(value = "sortId")
    private Integer sortId;

    @JoinColumn(value = "url", type = AttachmentModel.class, leftColumn = "inspectImgAttachment", rightColumn = "guid")
    private String inspectImgAttachmentUrl; //检查图片的路径
    @JoinColumn(value = "url", type = AttachmentModel.class, leftColumn = "changeImgAttachment", rightColumn = "guid")
    private String changeImgAttachmentUrl; //修正图片的路径

    public AttachmentSecurityModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getSecurityGuid() {
        return securityGuid;
    }

    public void setSecurityGuid(String securityGuid) {
        this.securityGuid = securityGuid;
    }

    public String getInspectImgAttachment() {
        return inspectImgAttachment;
    }

    public void setInspectImgAttachment(String inspectImgAttachment) {
        this.inspectImgAttachment = inspectImgAttachment;
    }

    public String getChangeImgAttachment() {
        return changeImgAttachment;
    }

    public void setChangeImgAttachment(String changeImgAttachment) {
        this.changeImgAttachment = changeImgAttachment;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getInspectImgAttachmentUrl() {
        return inspectImgAttachmentUrl;
    }

    public void setInspectImgAttachmentUrl(String inspectImgAttachmentUrl) {
        this.inspectImgAttachmentUrl = inspectImgAttachmentUrl;
    }

    public String getChangeImgAttachmentUrl() {
        return changeImgAttachmentUrl;
    }

    public void setChangeImgAttachmentUrl(String changeImgAttachmentUrl) {
        this.changeImgAttachmentUrl = changeImgAttachmentUrl;
    }
}
