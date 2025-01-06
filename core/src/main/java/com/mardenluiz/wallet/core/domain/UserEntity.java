package com.mardenluiz.wallet.core.domain;

import com.mardenluiz.wallet.core.domain.enums.UserTypeEnum;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class UserEntity {

    private UUID id;
    private String email;
    private String password;
    private TaxNumber textNumber;
    private String fullName;
    private UserTypeEnum type;
    private TransactionPin transactionPin;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public UserEntity(UUID id, String email, String password, TaxNumber textNumber, String fullName, UserTypeEnum type, TransactionPin transactionPin, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.textNumber = textNumber;
        this.fullName = fullName;
        this.type = type;
        this.transactionPin = transactionPin;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }

    public UserEntity(String email, String password, TaxNumber textNumber, String fullName, UserTypeEnum type, TransactionPin transactionPin) {
        this.email = email;
        this.password = password;
        this.textNumber = textNumber;
        this.fullName = fullName;
        this.type = type;
        this.transactionPin = transactionPin;
    }

    public UserEntity() {
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public TaxNumber getTextNumber() {
        return textNumber;
    }

    public void setTextNumber(TaxNumber textNumber) {
        this.textNumber = textNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserEntity that = (UserEntity) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
