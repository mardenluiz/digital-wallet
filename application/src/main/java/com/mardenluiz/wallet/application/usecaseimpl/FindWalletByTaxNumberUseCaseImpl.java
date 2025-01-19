package com.mardenluiz.wallet.application.usecaseimpl;

import com.mardenluiz.wallet.application.gateway.FindWalletByTaxNumberGateway;
import com.mardenluiz.wallet.core.domain.Wallet;
import com.mardenluiz.wallet.core.exception.NotFoundException;
import com.mardenluiz.wallet.core.exception.enums.ErrorCodeEnum;
import com.mardenluiz.wallet.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {

    private final FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws NotFoundException {
        var wallet = findWalletByTaxNumberGateway.FindByTaxNumber(taxNumber);

        if (wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }
        return null;
    }
}
