package com.mardenluiz.wallet.core.exception;

public class EmailException extends Throwable {

    private String code;

    public EmailException(String message, String code) {
        super(message);
        this.code = code;
    }
}
