package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {
    BigDecimal consult(Wallet wallet);
}
