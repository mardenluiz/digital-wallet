package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.exception.*;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin);
}
