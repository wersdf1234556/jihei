package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class NewsTypeQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "like", field = "name")
    private String name;
    @Operator(value = "eq", field = "sign")
    private String sign;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
