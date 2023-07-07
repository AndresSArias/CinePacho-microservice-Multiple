package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MultiplexRequestDto {

    @Pattern(regexp = "^[A-Za-zÁ-Úá-ú ]+$", message = "The name of multiplex must have only letters")
    private String name;
    @Pattern(regexp = "^[0-9]+$", message = "The number of theaters must have only numbers")
    private String numSala;
    @Pattern(regexp = "^[0-9]+$", message = "The number of point tickets must have only numbers")
    private String pointTicket;
    @Pattern(regexp = "^[0-9]+$", message = "The number of point snack must have only numbers")
    private String pointSnack;

}
