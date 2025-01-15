package com.mardenluiz.wallet.application.gateway;

import com.mardenluiz.wallet.core.domain.Wallet;

public interface CreateWalletGateway {

    void create(Wallet wallet);
}
