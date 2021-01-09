package org.tonzoc.exception.response;

public class ExceptionResponse {
    private Integer code;
    private String error;
    private String message;

    public ExceptionResponse(String error, String message) {
        this.code = 400;
        this.error = error;
        this.message = message;
    }

    public ExceptionResponse(Integer code, String error, String message) {
        this.code = code;
        this.error = error;
        this.message = message;
    }

    public ExceptionResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}