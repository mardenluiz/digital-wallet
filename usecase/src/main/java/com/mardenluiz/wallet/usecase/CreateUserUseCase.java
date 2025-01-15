package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.domain.UserEntity;
import com.mardenluiz.wallet.core.exception.EmailException;
import com.mardenluiz.wallet.core.exception.InternalServerErrorException;
import com.mardenluiz.wallet.core.exception.TaxNumberException;
import com.mardenluiz.wallet.core.exception.TransactionPinException;


public interface CreateUserUseCase {
    void create(UserEntity user, String pin) throws TaxNumberException, EmailException, InternalServerErrorException;
}
