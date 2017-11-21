package com.kowalczyk.workouter.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by JK on 2017-08-07.
 */
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class CannotCreateObjectException extends RuntimeException {

    public CannotCreateObjectException(String className) {
        super(String.format("Can't create object: [%s]", className));
    }
}
