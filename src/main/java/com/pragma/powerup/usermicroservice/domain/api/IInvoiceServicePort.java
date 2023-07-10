package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.InvoiceCompleteRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ObjectCreateResponseDto;

public interface IInvoiceServicePort {

    ObjectCreateResponseDto saveCompleteInvoice (InvoiceCompleteRequestDto invoiceCompleteRequestDto);
}
