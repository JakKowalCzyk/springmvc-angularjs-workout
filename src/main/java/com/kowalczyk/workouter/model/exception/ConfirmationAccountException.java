package com.kowalczyk.workouter.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by JK on 2017-09-17.
 */
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class ConfirmationAccountException extends RuntimeException {

    public ConfirmationAccountException(Long id) {
        super(String.format("Cannot proceed with confirmation procedure for user [%s]", id));
    }
}
