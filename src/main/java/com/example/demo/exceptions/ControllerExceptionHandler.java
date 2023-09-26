package com.example.demo.exceptions;

import com.example.demo.model.ErrorData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(NonValidData.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorData handleYourCustomException(NonValidData ex) {
        return new ErrorData(ex.getMessage());
    }
}
