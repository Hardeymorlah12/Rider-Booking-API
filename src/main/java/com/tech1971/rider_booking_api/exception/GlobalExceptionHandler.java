package com.tech1971.rider_booking_api.exception;

import com.tech1971.rider_booking_api.models.GenericResponse;
import jakarta.el.MethodNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<GenericResponse<?>> resourceNotFound(EntityNotFoundException ex) {
        return new ResponseEntity<>(new GenericResponse<>(false, ex.getMessage(), null, HttpStatus.OK.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse<Map<String, String>>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err ->
                errors.put(err.getField(), err.getDefaultMessage()));
        return new ResponseEntity<>(new GenericResponse<>(false, "Validation failed", errors, HttpStatus.OK.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<GenericResponse<String>> handleConstraintViolation(ConstraintViolationException ex) {
        return new ResponseEntity<>(new GenericResponse<>(false, "Constraint violation", ex.getMessage(), HttpStatus.OK.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse<String>> handleGenericException(Exception ex) {
        return new ResponseEntity<>(new GenericResponse<>(false, "Internal Server Error: " + ex.getMessage(), null, HttpStatus.OK.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodNotFoundException.class)
    public ResponseEntity<GenericResponse<String>> handleMethodNotFoundException(Exception ex) {
        return new ResponseEntity<>(new GenericResponse<>(false, "Internal Server Error: " + ex.getMessage(), null, HttpStatus.OK.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<GenericResponse<String>> badRequestException(Exception ex) {
        return new ResponseEntity<>(new GenericResponse<>(false, "Internal Server Error: " + ex.getMessage(), null, HttpStatus.OK.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


