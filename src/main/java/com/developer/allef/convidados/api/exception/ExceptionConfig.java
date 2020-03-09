package com.developer.allef.convidados.api.exception;

import com.developer.allef.convidados.domain.StandardError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
class ExceptionConfig
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ObjectNotFoundException.class, IllegalStateException.class })
    protected ResponseEntity<StandardError> emptyError(RuntimeException ex, HttpServletRequest request) {
        logger.error("Array Vazio");
        StandardError standardError = new StandardError(HttpStatus.FORBIDDEN.value(),ex.getMessage(),System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(standardError);
    }
}
