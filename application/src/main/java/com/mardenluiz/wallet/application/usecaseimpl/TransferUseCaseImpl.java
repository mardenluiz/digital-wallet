package com.mardenluiz.wallet.application.usecaseimpl;

import com.mardenluiz.wallet.application.gateway.TransferGateway;
import com.mardenluiz.wallet.core.domain.Transaction;
import com.mardenluiz.wallet.core.domain.Wallet;
import com.mardenluiz.wallet.core.exception.InternalServerErrorException;
import com.mardenluiz.wallet.core.exception.enums.ErrorCodeEnum;
import com.mardenluiz.wallet.usecase.CreateTransactionUseCase;
import com.mardenluiz.wallet.usecase.FindWalletByTaxNumberUseCase;
import com.mardenluiz.wallet.usecase.TransactionValidateUseCase;
import com.mardenluiz.wallet.usecase.TransferUseCase;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private final FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private final TransactionValidateUseCase transactionValidateUseCase;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final TransferGateway transferGateway;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransferGateway transferGateway) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws InternalServerErrorException {

        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        from.transfer(value);
        to.receiveTransfer(value);

        Transaction transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        transactionValidateUseCase.validate(transaction);

        if (!transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }
        return true;
    }
}
