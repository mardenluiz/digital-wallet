package com.mardenluiz.wallet.application.usecaseimpl;

import com.mardenluiz.wallet.application.gateway.UserNotificationGateway;
import com.mardenluiz.wallet.core.domain.Transaction;
import com.mardenluiz.wallet.usecase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {


    private final UserNotificationGateway notificationGateway;

    public UserNotificationUseCaseImpl(UserNotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return notificationGateway.notificate(transaction, email);
    }
}
