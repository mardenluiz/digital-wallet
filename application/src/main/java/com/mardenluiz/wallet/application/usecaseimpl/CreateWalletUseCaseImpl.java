package com.mardenluiz.wallet.application.usecaseimpl;

import com.mardenluiz.wallet.application.gateway.CreateWalletGateway;
import com.mardenluiz.wallet.core.domain.Wallet;
import com.mardenluiz.wallet.usecase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    private final CreateWalletGateway createWalletGateway;

    public CreateWalletUseCaseImpl(CreateWalletGateway createWalletGateway) {
        this.createWalletGateway = createWalletGateway;
    }

    @Override
    public void createWallet(Wallet wallet) {
        createWalletGateway.create(wallet);
    }
}
