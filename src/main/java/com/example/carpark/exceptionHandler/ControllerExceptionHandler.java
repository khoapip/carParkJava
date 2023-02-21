package com.example.carpark.exceptionHandler;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
//    public ErrorMessage allException(Exception ex, WebRequest request) {
//        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "INVALID URL ERROR");
//    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidatorMessage handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        ValidatorMessage message = new ValidatorMessage(HttpStatus.BAD_REQUEST.value(), "Invalid Input");
        ex.getBindingResult().getAllErrors().forEach((error) -> {

            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            message.addInvalid(fieldName, errorMessage);

        });
        return message;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ValidatorMessage handleConstraintException(
            ConstraintViolationException ex) {
        ValidatorMessage message = new ValidatorMessage(HttpStatus.BAD_REQUEST.value(), "Invalid Input");

        ex.getConstraintViolations().forEach((constraintViolation) -> {

            message.addInvalid(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
                }
        );

        return message;
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(EntityNotFoundException ex, WebRequest request) {

        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "No such ID exists in database");
    }

    @ExceptionHandler(value = {EntityExistsException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage duplicateID(EntityExistsException ex, WebRequest request) {

        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), "Duplicate ID in the DataBase");
    }



    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage invalidJson(HttpMessageNotReadableException ex, WebRequest request) {

        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), "Invalid Input. Check your input type");
    }
}