package com.mardenluiz.wallet.application.usecaseimpl;

import com.mardenluiz.wallet.application.gateway.CreateUserGateway;
import com.mardenluiz.wallet.core.domain.UserEntity;
import com.mardenluiz.wallet.core.domain.Wallet;
import com.mardenluiz.wallet.core.exception.EmailException;
import com.mardenluiz.wallet.core.exception.InternalServerErrorException;
import com.mardenluiz.wallet.core.exception.TaxNumberException;
import com.mardenluiz.wallet.core.exception.enums.ErrorCodeEnum;
import com.mardenluiz.wallet.usecase.CreateUserUseCase;
import com.mardenluiz.wallet.usecase.CreateWalletUseCase;
import com.mardenluiz.wallet.usecase.EmailAvailableUseCase;
import com.mardenluiz.wallet.usecase.TaxNumberAvailableUseCase;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private final EmailAvailableUseCase emailAvailableUseCase;
    private final CreateUserGateway createUserGateway;
    private final CreateWalletUseCase createWalletUseCase;


    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway, CreateWalletUseCase createWalletUseCase) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
        this.createWalletUseCase = createWalletUseCase;
    }

    @Override
    public void create(UserEntity user, String pin) throws TaxNumberException, EmailException, InternalServerErrorException {

        if (!taxNumberAvailableUseCase.taxNumberAvaliable(user.getTextNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if (!emailAvailableUseCase.emailAvailableEmail(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        var userSaved = createUserGateway.create(user);
        createWalletUseCase.createWallet(new Wallet(BigDecimal.ZERO, userSaved));

    }
}
