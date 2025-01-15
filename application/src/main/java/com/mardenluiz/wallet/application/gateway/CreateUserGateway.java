package com.mardenluiz.wallet.application.gateway;

import com.mardenluiz.wallet.core.domain.UserEntity;
import com.mardenluiz.wallet.core.domain.Wallet;

public interface CreateUserGateway {

    UserEntity create(UserEntity user);
}
