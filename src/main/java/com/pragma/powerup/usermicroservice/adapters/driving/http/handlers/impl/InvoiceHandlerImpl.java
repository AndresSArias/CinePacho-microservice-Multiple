package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.InvoiceCompleteRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ObjectCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.QualificationRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IInvoiceHandler;
import com.pragma.powerup.usermicroservice.domain.api.IInvoiceServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceHandlerImpl implements IInvoiceHandler {

    private final IInvoiceServicePort invoiceServicePort;

    @Override
    public void updateRating(QualificationRequestDto qualificationRequestDto) {
        invoiceServicePort.updateRating(qualificationRequestDto);
    }

    @Override
    public ObjectCreateResponseDto saveCompleteInvoice(InvoiceCompleteRequestDto invoiceCompleteRequestDto) {
        return invoiceServicePort.saveCompleteInvoice(invoiceCompleteRequestDto);
    }
}
