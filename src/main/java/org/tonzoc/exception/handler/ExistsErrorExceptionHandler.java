package org.tonzoc.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.tonzoc.exception.ExistsErrorException;
import org.tonzoc.exception.response.ExceptionResponse;

public class ExistsErrorExceptionHandler implements IExceptionHandler {
    @ExceptionHandler(ExistsErrorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handle(Exception exception) {
        return new ExceptionResponse("existsError", exception.getMessage());
    }
}
