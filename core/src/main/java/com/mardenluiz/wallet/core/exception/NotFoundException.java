package com.mardenluiz.wallet.core.exception;

public class NotFoundException extends Throwable {

    private String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
}
