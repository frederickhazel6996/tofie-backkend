package com.hazex.tofiebackend.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)
    {
          ExceptionResponse exceptionResponse=  new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));

          return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @Override
     protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final StringBuffer errors = new StringBuffer();
       for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
           errors.append("  ");
           errors.append(error.getField() + ": " + error.getDefaultMessage());
           errors.append("||");
       }

        ExceptionResponse exceptionResponse=  new ExceptionResponse(new Date(),"Validation Failed",errors.toString());


          return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
