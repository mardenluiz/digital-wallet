package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.domain.TransactionPin;

public interface CreateTransactionPinUseCase {
    void create(TransactionPin transactionPin);
}
