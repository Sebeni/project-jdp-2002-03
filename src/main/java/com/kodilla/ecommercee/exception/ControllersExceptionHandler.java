package com.kodilla.ecommercee.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllersExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllersExceptionHandler.class);
    
        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(GroupNotFoundException.class)
        public void handleGroupNotFound(GroupNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        }
}
