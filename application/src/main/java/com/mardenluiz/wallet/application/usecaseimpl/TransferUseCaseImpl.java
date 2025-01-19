package com.mardenluiz.wallet.application.usecaseimpl;

import com.mardenluiz.wallet.application.gateway.TransferGateway;
import com.mardenluiz.wallet.core.domain.Transaction;
import com.mardenluiz.wallet.core.domain.Wallet;
import com.mardenluiz.wallet.core.exception.InternalServerErrorException;
import com.mardenluiz.wallet.core.exception.NotFoundException;
import com.mardenluiz.wallet.core.exception.NotificationException;
import com.mardenluiz.wallet.core.exception.enums.ErrorCodeEnum;
import com.mardenluiz.wallet.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private final FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private final TransactionValidateUseCase transactionValidateUseCase;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final TransferGateway transferGateway;
    private final UserNotificationUseCase userNotificationUseCase;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransferGateway transferGateway, UserNotificationUseCase userNotificationUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws InternalServerErrorException, NotFoundException, NotificationException {

        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        from.transfer(value);
        to.receiveTransfer(value);

        Transaction transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        transactionValidateUseCase.validate(transaction);

        if (!transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        if (!userNotificationUseCase.notificate(transaction, to.getUserEntity().getEmail())) {
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());
        }

        return true;
    }
}
