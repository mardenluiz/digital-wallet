package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.domain.TransactionPin;

public interface TransactionPinValidateUseCase {
    Boolean validate(TransactionPin transactionPin);
}
