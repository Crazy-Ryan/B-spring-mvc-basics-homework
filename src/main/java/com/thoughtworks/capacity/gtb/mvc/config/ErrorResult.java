package com.thoughtworks.capacity.gtb.mvc.config;

public class ErrorResult {
    private int code;
    private String message;

    public ErrorResult(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
