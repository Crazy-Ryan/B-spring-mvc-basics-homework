package com.thoughtworks.capacity.gtb.mvc.config;

public class UsernamePasswordMismatchException extends RuntimeException{
    public UsernamePasswordMismatchException(final String message) {
        super(message);
    }
}
