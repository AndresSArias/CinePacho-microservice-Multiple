package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.InvoiceCompleteRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ObjectCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.QualificationRequestDto;

public interface IInvoiceServicePort {
    void updateRating (QualificationRequestDto qualificationRequestDto);
    ObjectCreateResponseDto saveCompleteInvoice (InvoiceCompleteRequestDto invoiceCompleteRequestDto);
}
