package com.mardenluiz.wallet.application.gateway;

import com.mardenluiz.wallet.core.domain.Transaction;

public interface UserNotificationGateway {

    Boolean notificate(Transaction transaction, String email);
}
