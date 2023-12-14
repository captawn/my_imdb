package com.example.demo.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class EmployeeExceptionHandler {


/*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(HttpServletRequest request,Exception ex) {

        String err = "Ohhh we have Exception : " + ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

    }
*/

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(HttpServletRequest request,NoSuchElementException ex) {
        String err = "Unable to load: " + request.getRequestURI();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }


}
