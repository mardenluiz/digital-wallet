package com.mardenluiz.wallet.application.usecaseimpl;

import com.mardenluiz.wallet.application.gateway.EmailAvailableGateway;

public class EmailAvailableUseCaseImpl implements EmailAvailableGateway {

    private final EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean emailAvailableEmail(String email) {
        return emailAvailableGateway.emailAvailableEmail(email);
    }
}
