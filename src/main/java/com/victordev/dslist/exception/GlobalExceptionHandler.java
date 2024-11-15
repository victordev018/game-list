package com.victordev.dslist.exception;

import com.victordev.dslist.service.exception.GameListNotFoundException;
import com.victordev.dslist.service.exception.GameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<StandardError> gameNotFoundException(GameNotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError responseException = new StandardError(status.value(), exception.getMessage());
        return ResponseEntity.status(status.value()).body(responseException);
    }

    @ExceptionHandler(GameListNotFoundException.class)
    public ResponseEntity<StandardError> gameListNotFoundException(GameListNotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError responseException = new StandardError(status.value(), exception.getMessage());
        return ResponseEntity.status(status.value()).body(responseException);
    }

}
