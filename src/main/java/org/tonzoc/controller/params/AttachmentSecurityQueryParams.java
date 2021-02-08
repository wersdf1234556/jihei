package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class AttachmentSecurityQueryParams  {

    @Operator(value = "eq",field = "guid")
    private String guid;
    @Operator(value = "eq",field = "securityGuid")
    private String securityGuid;
    @Operator(value = "eq",field = "inspectImgAttachment")
    private String inspectImgAttachment;
    @Operator(value = "eq",field = "changeImgAttachment")
    private String changeImgAttachment;
    @Operator(value = "eq",field = "sortId")
    private Integer sortId;

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
}
