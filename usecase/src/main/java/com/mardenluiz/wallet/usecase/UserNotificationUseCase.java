package com.mardenluiz.wallet.usecase;

import com.mardenluiz.wallet.core.domain.Transaction;

public interface UserNotificationUseCase {
    Boolean notificate(Transaction transaction, String email);
}
