package com.mardenluiz.wallet.application.gateway;

import com.mardenluiz.wallet.core.domain.TransactionPin;

public interface CreateTransactionPinGateway {
    void create(TransactionPin transactionPin);
}
