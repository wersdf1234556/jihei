package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class NewsQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "sign")
    private String sign;  //栏目的唯一标识
    @Operator(value = "eq", field = "title")
    private String title; //小标题
    @Operator(value = "eq", field = "topFlag")
    private String topFlag;
    @Operator(value = "dateLike", field = "createdAt")
    private String createdAt;


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopFlag() {
        return topFlag;
    }

    public void setTopFlag(String topFlag) {
        this.topFlag = topFlag;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
