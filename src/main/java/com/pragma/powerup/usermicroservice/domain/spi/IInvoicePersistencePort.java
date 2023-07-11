package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.InvoiceCompleteRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ObjectCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.QualificationRequestDto;

public interface IInvoicePersistencePort {
    void updateRating (QualificationRequestDto qualificationRequestDto);
    ObjectCreateResponseDto saveCompleteInvoice (InvoiceCompleteRequestDto invoiceCompleteRequestDto);
}
