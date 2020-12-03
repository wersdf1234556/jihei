package org.tonzoc.support.param;

public class SqlQueryParam {

    private String queryField;
    private String queryValue;
    private String operator;

    public SqlQueryParam() {
    }

    public SqlQueryParam(String queryField, String queryValue, String operator) {
        this.queryField = queryField;
        this.queryValue = queryValue;
        this.operator = operator;
    }

    public String getQueryField() {
        return queryField;
    }

    public void setQueryField(String queryField) {
        this.queryField = queryField;
    }

    public String getQueryValue() {
        return queryValue;
    }

    public void setQueryValue(String queryValue) {
        this.queryValue = queryValue;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
