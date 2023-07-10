package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvoiceSnackRequestDto {

    @Pattern(regexp = "^[0-9]+$" , message = "The idSnak must have only numbers")
    private String idSnack;

    @Pattern(regexp = "^[0-9]+$" , message = "The quatity of snack must have only numbers")
    private String quantitySnack;

}
