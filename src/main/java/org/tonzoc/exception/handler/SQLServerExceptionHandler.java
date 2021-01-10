package org.tonzoc.exception.handler;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.tonzoc.exception.response.ExceptionResponse;

@ControllerAdvice
public class SQLServerExceptionHandler implements IExceptionHandler {

    @Override
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ExceptionResponse handle(Exception exception) {
        return new ExceptionResponse("system_error", exception.getMessage());
    }
}
