package com.newsfeed.api.exception;

public class UnableToFetchException extends RuntimeException{
    public UnableToFetchException(String message, Throwable cause) {
        super(message, cause);
    }
}
