package com.mardenluiz.wallet.application.usecaseimpl;

import com.mardenluiz.wallet.application.gateway.UserAuthenticateGateway;
import com.mardenluiz.wallet.core.exception.AuthenticateException;
import com.mardenluiz.wallet.core.exception.enums.ErrorCodeEnum;
import com.mardenluiz.wallet.usecase.UserAuthenticateUseCase;

import javax.naming.AuthenticationException;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {

    private final UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {
        if (!userAuthenticateGateway.authenticate(username, password)) {
            throw new AuthenticateException(ErrorCodeEnum.ATH.getCode(), ErrorCodeEnum.ATH.getCode());
        }

        return true;
    }
}
