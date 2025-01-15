package com.mardenluiz.wallet.core.exception;

public class InternalServerErrorException extends Throwable {
    private String code;

    public InternalServerErrorException(String message, String code) {
        super(message);
        this.code = code;
    }
}
