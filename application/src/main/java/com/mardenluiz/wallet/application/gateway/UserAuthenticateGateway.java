package com.mardenluiz.wallet.application.gateway;

public interface UserAuthenticateGateway {

    Boolean authenticate(String username, String password);
}
