package com.mardenluiz.wallet.core.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Tax Number invalid", "ON0001"),

    TR0001("Logistics user does not have the transfer function available", "TR0001"),

    TR0002("Balance unavailable", "TR0002"),

    TRP0001("Pin invalid", "TRP-001"),

    ON0002("", "ON0002"),

    ON0003("", "ON0003"),

    ON0004("", "ON0004"),

    TR0003("Error creating transfer", "TR-0003"),

    WA0001("Wallet not found", "WA-0001"),

    NO0001("Error notifying user", "NO-0001");

    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
