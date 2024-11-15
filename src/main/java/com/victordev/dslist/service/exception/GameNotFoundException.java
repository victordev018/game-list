package com.victordev.dslist.service.exception;

public class GameNotFoundException extends RuntimeException{

    private static final Long serialVersionUUID = 1L;

    public GameNotFoundException(String message) {
        super(message);
    }
}
