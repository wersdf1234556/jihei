package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class NewsQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "titleGuid")
    private String titleGuid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitleGuid() {
        return titleGuid;
    }

    public void setTitleGuid(String titleGuid) {
        this.titleGuid = titleGuid;
    }
}
