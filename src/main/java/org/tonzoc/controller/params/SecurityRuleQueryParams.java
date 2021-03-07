package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class SecurityRuleQueryParams {

    @Operator(value = "eq", field = "documentGuid")
    private String documentGuid;

    @Operator(value = "or", field = "tenderGuid")
    private String tenderGuid;

    @Operator(value = "eq", field = "securityRuleGuid")
    private String securityRuleGuid;

    @Operator(value = "eq", field = "createPersonGuid")
    private String createPersonGuid;

    @Operator(value = "eq", field = "score")
    private Integer score;

    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    public String getDocumentGuid() {
        return documentGuid;
    }

    public void setDocumentGuid(String documentGuid) {
        this.documentGuid = documentGuid;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getSecurityRuleGuid() {
        return securityRuleGuid;
    }

    public void setSecurityRuleGuid(String securityRuleGuid) {
        this.securityRuleGuid = securityRuleGuid;
    }

    public String getCreatePersonGuid() {
        return createPersonGuid;
    }

    public void setCreatePersonGuid(String createPersonGuid) {
        this.createPersonGuid = createPersonGuid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
