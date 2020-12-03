package org.tonzoc.exception.handler;

import org.tonzoc.exception.response.ExceptionResponse;

public interface IExceptionHandler {

    ExceptionResponse handle(Exception exception);
}
