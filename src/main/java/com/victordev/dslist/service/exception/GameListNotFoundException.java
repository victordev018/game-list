package com.victordev.dslist.service.exception;

public class GameListNotFoundException extends RuntimeException{

    private static final Long serialVersionUUID = 1L;

    public GameListNotFoundException(String message) {
        super(message);
    }
}
