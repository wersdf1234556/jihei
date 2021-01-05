package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class NewsQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "eq", field = "sign")
    private String sign;  //栏目的唯一标识
    @Operator(value = "eq", field = "subTitle")
    private String subTitle; //小标题
    @Operator(value = "neq", field = "attachmentGuid")
    private String attachmentGuid="";  //图片不为空的


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
}
