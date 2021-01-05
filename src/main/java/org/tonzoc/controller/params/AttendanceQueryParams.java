package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class AttendanceQueryParams {
    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "like", field = "idCard")
    private String idCard;
    @Operator(value = "like", field = "createdAt")
    private String createdAt;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
