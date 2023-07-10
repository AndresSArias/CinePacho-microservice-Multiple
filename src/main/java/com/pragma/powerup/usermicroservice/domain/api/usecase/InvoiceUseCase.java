package com.pragma.powerup.usermicroservice.domain.api.usecase;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.InvoiceCompleteRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ObjectCreateResponseDto;
import com.pragma.powerup.usermicroservice.domain.api.IInvoiceServicePort;
import com.pragma.powerup.usermicroservice.domain.spi.IInvoicePersistencePort;

public class InvoiceUseCase implements IInvoiceServicePort {
    private final IInvoicePersistencePort invoicePersistencePort;

    public InvoiceUseCase(IInvoicePersistencePort invoicePersistencePort) {
        this.invoicePersistencePort = invoicePersistencePort;
    }

    @Override
    public ObjectCreateResponseDto saveCompleteInvoice(InvoiceCompleteRequestDto invoiceCompleteRequestDto) {
        return invoicePersistencePort.saveCompleteInvoice(invoiceCompleteRequestDto);
    }
}
