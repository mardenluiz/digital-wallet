package com.mardenluiz.wallet.application.gateway;

import com.mardenluiz.wallet.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {

    BigDecimal consult(Wallet waller);
}
