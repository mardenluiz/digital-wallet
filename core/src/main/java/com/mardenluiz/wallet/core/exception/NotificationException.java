package com.mardenluiz.wallet.core.exception;

public class NotificationException extends Throwable{

    private String code;

    public NotificationException(String message, String code) {
        super(message);
        this.code = code;
    }
}
