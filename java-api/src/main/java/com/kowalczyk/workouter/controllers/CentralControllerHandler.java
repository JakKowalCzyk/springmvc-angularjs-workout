package com.kowalczyk.workouter.controllers;

import com.kowalczyk.workouter.model.response.ApiError;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by JKowalczyk on 2017-06-21.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CentralControllerHandler {
    final static private Logger logger = LoggerFactory.getLogger(CentralControllerHandler.class);

    @InitBinder
    public void binder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                setValue(new Timestamp(Long.parseLong(value)));
            }
        });
    }

    @ExceptionHandler({BindException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError bindException(BindException e, Locale locale) {
        List<ObjectError> allErrors = e.getAllErrors();
        ObjectError error = allErrors.get(0);
        logger.error(e.getMessage());
        String type = StringUtils.substringBefore(error.getDefaultMessage(), "|");
        String message = StringUtils.substringAfter(error.getDefaultMessage(), "|");

        return new ApiError(message, type);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ApiError methodArgumentNotValidException(MethodArgumentNotValidException e, Locale locale) {
        return new ApiError(e.getBindingResult().getAllErrors().stream().map(er -> er.getDefaultMessage()).collect(Collectors.joining("; ")), "REQUEST_ARGUMENTS_NOT_VALID");
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError exception(Exception e, Locale locale) {
        e.printStackTrace();
        return new ApiError(String.format("%s: %s", e.getClass().getName(), e.getMessage() != null ? e.getMessage().trim() : ""), "ERR_SERVER");
    }

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiError exceptionDenied(Exception e, Locale locale) {
        e.printStackTrace();
        return new ApiError(String.format("%s: %s", e.getClass().getName(), e.getMessage() != null ? e.getMessage().trim() : ""), "ACCESS_DENIED");
    }


}
