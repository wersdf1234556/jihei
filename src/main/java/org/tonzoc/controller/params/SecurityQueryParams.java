package org.tonzoc.controller.params;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.Operator;

public class SecurityQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "createPersonName")
    private String createPersonName;
    @Operator(value = "like", field = "describe")
    private String describe;
    @Operator(value = "or", field = "changTenderGuid")
    private String tenderManage;
    @Operator(value = "eq", field = "securityRuleGuid")
    private String securityRuleGuid;
    @Operator(value = "eq", field = "approvalTenderGuid")
    private String approvalTenderGuid;
    @Operator(value = "eq", field = "ccPersonGuid")
    private String ccPersonGuid;
    @Operator(value = "or", field = "status")
    private String status;
    @Operator(value = "eq", field = "changTenderGuid")
    private String changTenderGuid;
    @Operator(value = "eq", field = "accounType")
    private String accounType;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getTenderManage() {
        return tenderManage;
    }

    public void setTenderManage(String tenderManage) {
        this.tenderManage = tenderManage;
    }

    public String getSecurityRuleGuid() {
        return securityRuleGuid;
    }

    public void setSecurityRuleGuid(String securityRuleGuid) {
        this.securityRuleGuid = securityRuleGuid;
    }

    public String getApprovalTenderGuid() {
        return approvalTenderGuid;
    }

    public void setApprovalTenderGuid(String approvalTenderGuid) {
        this.approvalTenderGuid = approvalTenderGuid;
    }

    public String getCcPersonGuid() {
        return ccPersonGuid;
    }

    public void setCcPersonGuid(String ccPersonGuid) {
        this.ccPersonGuid = ccPersonGuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public String getChangTenderGuid() {
        return changTenderGuid;
    }

    public void setChangTenderGuid(String changTenderGuid) {
        this.changTenderGuid = changTenderGuid;
    }

    public String getAccounType() {
        return accounType;
    }

    public void setAccounType(String accounType) {
        this.accounType = accounType;
    }
}
