package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class InvoiceCompleteRequestDto {

    @Pattern(regexp = "^[0-9]+$" , message = "The idMovie must have only numbers")
    private String idMovie;

    @Pattern(regexp = "^[0-9]+$" , message = "The idTheater must have only numbers")
    private String idTheater;

    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$", message = "The schedule format is incorrect")
    private String schedule;

    @Pattern(regexp = "^\\d+(,\\d+)*$", message = "The chairGeneral must be separated by commas")
    private String chairGeneral;
    @Pattern(regexp = "^\\d+(,\\d+)*$", message = "The chaiPreferential must be separated by commas")
    private String chaiPreferential;

    @Pattern(regexp = "^[0-9]+$" , message = "The numberDocument of client must have only numbers")
    private String numberDocument;

    private List<InvoiceSnackRequestDto> snaks;


}
