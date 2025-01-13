package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.domain.TransactionPin;

public interface UpdateTransactionPinUseCase {
    TransactionPin update(TransactionPin transactionPin);
}
