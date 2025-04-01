package com.example.demo.exception;

import com.example.demo.common.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class HandleException {
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(StudentNotFoundException.class)
    public Response handleEntityNotFoundException(StudentNotFoundException ex, HttpServletRequest req) {
        log.error("NOT FOUND: {}, uri: {}, method: {}, message: {}",
                ex.getClass().getSimpleName(), req.getRequestURI(), req.getMethod(), ex.getLocalizedMessage());
        return new Response(NOT_FOUND.value(), ex.getLocalizedMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(StudentException.class)
    public Response handleEntityException(StudentException ex, HttpServletRequest req) {
        log.error("BAD REQUEST: {}, uri: {}, method: {}, message: {}",
                ex.getClass().getSimpleName(), req.getRequestURI(), req.getMethod(), ex.getLocalizedMessage());
        return new Response(BAD_REQUEST.value(), ex.getLocalizedMessage());
    }
}

