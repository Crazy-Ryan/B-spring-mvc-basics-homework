package com.thoughtworks.capacity.gtb.mvc.config;

import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResult handle(MethodArgumentNotValidException ex) {
        return new ErrorResult(HttpStatus.BAD_REQUEST.value(),
                Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResult handle(UserExistsException ex) {
        return new ErrorResult(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(UsernamePasswordMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResult handle(UsernamePasswordMismatchException ex) {
        return new ErrorResult(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
