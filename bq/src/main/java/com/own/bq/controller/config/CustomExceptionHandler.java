package com.own.bq.controller.config;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.own.bq.controller.config.exception.ExceptionMessage.ExceptionMessageBuilder;
import com.own.bq.controller.config.exception.ExceptionType;
import com.own.bq.controller.config.exception.abstrct.FunctionalException;
import com.own.bq.controller.config.exception.abstrct.TechnicalException;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler  {

	@ExceptionHandler({TechnicalException.class,FunctionalException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        
        return handleExceptionInternal(ex, new ExceptionMessageBuilder()
        		.path(ServletUriComponentsBuilder.fromCurrentRequestUri().build().toString())
        		.message(bodyOfResponse)
        		.exceptionType(TechnicalException.class.isAssignableFrom(ex.getClass()) ?
        				ExceptionType.TECHNICAL : ExceptionType.FONCTIONAL).build(), new HttpHeaders(),
        		HttpStatus.CONFLICT, request);
    }
}
