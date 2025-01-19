package com.mardenluiz.wallet.application.gateway;

import com.mardenluiz.wallet.core.domain.Transaction;

public interface CreateTransactionGateway {
    Transaction create(Transaction transaction);
}
