package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MultiplexRequestPageDto {
    @NotNull
    @Min(value = 0, message = "El valor del número de la página de Multiplex a consultar debe ser mayor o igual a cero")
    private int page;

    @NotNull
    @Min(value = 0, message = "El valor del número de Multiplex por página debe ser mayor o igual a cero")
    private int size;
}
