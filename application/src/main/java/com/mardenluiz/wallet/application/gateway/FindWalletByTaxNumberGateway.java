package com.mardenluiz.wallet.application.gateway;

import com.mardenluiz.wallet.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {

    Wallet FindByTaxNumber(String texNumber);
}
