package org.tonzoc.configuration.security.support;

public class SimpleResponse {

    private String error;
    private Object content;

    public SimpleResponse(String error, Object content) {
        this.error = error;
        this.content = content;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
