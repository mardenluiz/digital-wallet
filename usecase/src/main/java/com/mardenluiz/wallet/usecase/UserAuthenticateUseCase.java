package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.exception.AuthenticateException;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String username, String password) throws AuthenticateException;
}
