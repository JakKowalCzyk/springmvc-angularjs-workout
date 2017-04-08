package com.kowalczyk.workouter.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by JK on 2017-04-08.
 */
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class DeleteException extends RuntimeException {
    public DeleteException(Long id) {
        super(String.format("Can't delete object with id %d, object being used", id));
    }
}
