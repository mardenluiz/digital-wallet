package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.domain.Transaction;
import com.mardenluiz.wallet.core.exception.TransferException;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction) throws TransferException;
}
