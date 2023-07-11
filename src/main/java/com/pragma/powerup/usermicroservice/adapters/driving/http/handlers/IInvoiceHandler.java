package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.InvoiceCompleteRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ObjectCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.QualificationRequestDto;

public interface IInvoiceHandler {

    void updateRating (QualificationRequestDto qualificationRequestDto);
    ObjectCreateResponseDto saveCompleteInvoice (InvoiceCompleteRequestDto invoiceCompleteRequestDto);

}
