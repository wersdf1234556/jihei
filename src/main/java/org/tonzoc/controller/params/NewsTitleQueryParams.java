package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class NewsTitleQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "like", field = "title")
    private String title;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
