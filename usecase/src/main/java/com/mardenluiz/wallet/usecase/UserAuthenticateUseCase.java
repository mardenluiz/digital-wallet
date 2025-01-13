package com.mardenluiz.wallet.usecase;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String username, String password);
}
