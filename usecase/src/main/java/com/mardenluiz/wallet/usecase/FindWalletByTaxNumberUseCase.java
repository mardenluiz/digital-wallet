package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.domain.Wallet;
import com.mardenluiz.wallet.core.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String TaxNumber) throws NotFoundException;
}
