package com.mitocode.exception;

import com.mitocode.dto.GenericResponse;
import org.springframework.boot.Banner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;


@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse<CustomErrorResponse>> handleAllException(Exception ex, WebRequest req){

        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(),ex.getMessage(),req.getDescription(false));
        return new ResponseEntity<>(new GenericResponse<>(500,"BACKEND ERROR", Arrays.asList(errorResponse)),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<GenericResponse<CustomErrorResponse>> handleModelNotFoundException(ModelNotFoundException ex, WebRequest req){

        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(),ex.getMessage(),req.getDescription(false));
        return new ResponseEntity<>(new GenericResponse<>(404,"NOT FOUND", Arrays.asList(errorResponse)),HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest req ){
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(),ex.getMessage(),req.getDescription(false));
        return new ResponseEntity<>(new GenericResponse<>(400,"BAD REQUEST", Arrays.asList(errorResponse)),HttpStatus.BAD_REQUEST);
    }
}
