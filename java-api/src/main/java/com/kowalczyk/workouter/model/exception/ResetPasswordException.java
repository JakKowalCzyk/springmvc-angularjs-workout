package com.kowalczyk.workouter.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by JK on 2018-01-15.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResetPasswordException extends RuntimeException {

    public ResetPasswordException() {
        super(String.format("Cannot proceed with password reset procedure"));
    }
}
