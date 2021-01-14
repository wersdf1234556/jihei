package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class DocumentQueryParams {

    @Operator(value = "like", field = "title")
    private String title;

    @Operator(value = "eq", field = "createPersonGuid")
    private String createPersonGuid;

    @Operator(value = "eq", field = "status")
    private String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatePersonGuid() {
        return createPersonGuid;
    }

    public void setCreatePersonGuid(String createPersonGuid) {
        this.createPersonGuid = createPersonGuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
