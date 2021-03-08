package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class SecurityChangQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "like", field = "chang")
    private String chang;
    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;
    @Operator(value = "or", field = "tenderGuid")
    private String tenderManage;
    @Operator(value = "eq", field = "currentTenderGuid")
    private String currentTenderGuid;
    @Operator(value = "eq", field = "ccPersonGuid")
    private String ccPersonGuid;
    @Operator(value = "eq", field = "createPersonName")
    private String createPersonName;
    @Operator(value = "eq", field = "approvalPersonName")
    private String approvalPersonName;
    @Operator(value = "eq", field = "status")
    private String status;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getChang() {
        return chang;
    }

    public void setChang(String chang) {
        this.chang = chang;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getTenderManage() {
        return tenderManage;
    }

    public void setTenderManage(String tenderManage) {
        this.tenderManage = tenderManage;
    }

    public String getCurrentTenderGuid() {
        return currentTenderGuid;
    }

    public void setCurrentTenderGuid(String currentTenderGuid) {
        this.currentTenderGuid = currentTenderGuid;
    }

    public String getCcPersonGuid() {
        return ccPersonGuid;
    }

    public void setCcPersonGuid(String ccPersonGuid) {
        this.ccPersonGuid = ccPersonGuid;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public String getApprovalPersonName() {
        return approvalPersonName;
    }

    public void setApprovalPersonName(String approvalPersonName) {
        this.approvalPersonName = approvalPersonName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
