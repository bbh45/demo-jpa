package com.example.demojpa.util;

import com.example.demojpa.exceptions.PersonNotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@ControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> errors = fieldErrors.stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());

        ResponseEntity responseEntity = new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        return responseEntity;

    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity handleIndexOutOfBoundsException(IndexOutOfBoundsException ex){
        String message = ex.getMessage();
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity handlePersonNotFoundException(PersonNotFoundException ex){
        String message = ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

}

