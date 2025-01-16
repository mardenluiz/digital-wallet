package com.mardenluiz.wallet.application.usecaseimpl;

import com.mardenluiz.wallet.application.gateway.TaxNumberAvailableGateway;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableGateway {

    private final TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        return taxNumberAvailableGateway.taxNumberAvailable(taxNumber);
    }
}
