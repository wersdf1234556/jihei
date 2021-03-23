package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class SecurityChangQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "like", field = "chang")
    private String chang;
    @Operator(value = "eq", field = "securityGuid")
    private String securityGuid;
    @Operator(value = "eq", field = "changTenderGuid")
    private String changTenderGuid;
    @Operator(value = "or", field = "changTenderGuid")
    private String tenderManage;
    @Operator(value = "eq", field = "approvalTenderGuid")
    private String approvalTenderGuid;
    @Operator(value = "or", field = "status")
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

    public String getChangTenderGuid() {
        return changTenderGuid;
    }

    public void setChangTenderGuid(String changTenderGuid) {
        this.changTenderGuid = changTenderGuid;
    }

    public String getTenderManage() {
        return tenderManage;
    }

    public void setTenderManage(String tenderManage) {
        this.tenderManage = tenderManage;
    }

    public String getApprovalTenderGuid() {
        return approvalTenderGuid;
    }

    public void setApprovalTenderGuid(String approvalTenderGuid) {
        this.approvalTenderGuid = approvalTenderGuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSecurityGuid() {
        return securityGuid;
    }

    public void setSecurityGuid(String securityGuid) {
        this.securityGuid = securityGuid;
    }
}
