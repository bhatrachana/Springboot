package com.example.crud.example.Exception;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class INSException {
	
 @ExceptionHandler(NotFoundException.class)
 public ResponseEntity<Errordetails> handleException(NotFoundException exception, WebRequest request) {
     Errordetails details = new Errordetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
     return new ResponseEntity<Errordetails>(details, HttpStatus.NOT_FOUND);
 }

 @ExceptionHandler(Exception.class)
 public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
     Errordetails details = new Errordetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
     return new ResponseEntity<Object>(details, HttpStatus.INTERNAL_SERVER_ERROR);
 }



 protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
         HttpHeaders headers, HttpStatus status, WebRequest request) {

     Map<String, String> errors = new HashMap<>();
     ex.getBindingResult().getFieldErrors()
             .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
     return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
 }
}
