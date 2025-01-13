package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.domain.Wallet;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String TaxNumber);
}
