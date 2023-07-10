package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.InvoiceCompleteRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ObjectCreateResponseDto;

public interface IInvoiceHandler {

    ObjectCreateResponseDto saveCompleteInvoice (InvoiceCompleteRequestDto invoiceCompleteRequestDto);

}
