package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class TenderScoreQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "eq", field = "scores")
    private Integer scores;

    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;

    @Operator(value = "eq", field = "securityGuid")
    private String securityGuid;

    @Operator(value = "or", field = "tenderGuid")
    private String tenderManage;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
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

    public String getSecurityGuid() {
        return securityGuid;
    }

    public void setSecurityGuid(String securityGuid) {
        this.securityGuid = securityGuid;
    }
}
