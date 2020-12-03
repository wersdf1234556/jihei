package org.tonzoc.controller.response;

import java.util.List;

public class PageResponse {

    private Long total;
    private List list;

    public PageResponse() {
    }

    public PageResponse(Long total, List list) {
        this.total = total;
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
