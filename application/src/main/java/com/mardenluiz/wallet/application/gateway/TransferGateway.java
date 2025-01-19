package com.mardenluiz.wallet.application.gateway;

import com.mardenluiz.wallet.core.domain.Transaction;

public interface TransferGateway {

    boolean transfer(Transaction transaction);
}
