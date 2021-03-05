package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class AttachmentSecurityQueryParams  {

    @Operator(value = "eq",field = "guid")
    private String guid;
    @Operator(value = "like",field = "guid")
    private String name;
    @Operator(value = "eq",field = "fileType")
    private Integer fileType;
    @Operator(value = "eq",field = "securityGuid")
    private String securityGuid;
    @Operator(value = "eq",field = "securityChangGuid")
    private String securityChangGuid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getSecurityChangGuid() {
        return securityChangGuid;
    }

    public void setSecurityChangGuid(String securityChangGuid) {
        this.securityChangGuid = securityChangGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
