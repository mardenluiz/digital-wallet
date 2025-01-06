package com.mardenluiz.wallet.core.exception;

public class TaxNumberException extends RuntimeException {

    private String code;

    public TaxNumberException(String message, String code) {
        super(message);
        this.code = code;
    }
}
