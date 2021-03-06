package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class UnsafeQueryParams {

    @Operator(value = "eq", field = "guid")
    private Integer guid;

    @Operator(value = "like", field = "parts")
    private String parts;

    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;

    @Operator(value = "or", field = "tenderGuid")
    private String tenderManage;

    @Operator(value = "eq", field = "unsafeTypeGuid")
    private String unsafeTypeGuid;

    public Integer getGuid() {
        return guid;
    }

    public void setGuid(Integer guid) {
        this.guid = guid;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getUnsafeTypeGuid() {
        return unsafeTypeGuid;
    }

    public void setUnsafeTypeGuid(String unsafeTypeGuid) {
        this.unsafeTypeGuid = unsafeTypeGuid;
    }

    public String getTenderManage() {
        return tenderManage;
    }

    public void setTenderManage(String tenderManage) {
        this.tenderManage = tenderManage;
    }
}
