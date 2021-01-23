package com.thoughtworks.capacity.gtb.mvc.config;

public class UserExistsException extends RuntimeException{
    public UserExistsException(final String message) {
        super(message);
    }
}
