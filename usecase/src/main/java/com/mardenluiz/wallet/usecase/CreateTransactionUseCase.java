package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.domain.Transaction;

public interface CreateTransactionUseCase {
    Transaction create(Transaction transaction);
}
