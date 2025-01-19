package com.mardenluiz.wallet.application.usecaseimpl;

import com.mardenluiz.wallet.application.gateway.TransactionValidateGateway;
import com.mardenluiz.wallet.core.domain.Transaction;
import com.mardenluiz.wallet.core.exception.TransferException;
import com.mardenluiz.wallet.core.exception.enums.ErrorCodeEnum;
import com.mardenluiz.wallet.usecase.TransactionValidateUseCase;

public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {

    private final TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateUseCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        var transactionValidate = transactionValidateGateway.validate(transaction);

        if (!transactionValidate) {
            throw  new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }

        return true;
    }
}
