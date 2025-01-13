package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.domain.UserEntity;


public interface CreateUserUseCase {
    void create(UserEntity user, String pin);
}
