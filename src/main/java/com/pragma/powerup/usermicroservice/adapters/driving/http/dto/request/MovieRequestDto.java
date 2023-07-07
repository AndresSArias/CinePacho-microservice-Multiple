package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MovieRequestDto {
    @Pattern(regexp = "^[A-Za-zÁ-Úá-ú0-9 ]+$", message = "The description of plate must have only letters and numbers")
    private String title;
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "El formato debe ser HH:mm")
    private String duration;
    @Pattern(regexp = "^[0-9]+$" , message = "The NIT of restaurant must have only numbers")
    private String yearAllowed;
    @Pattern(regexp = "^[A-Za-zÁ-Úá-ú ]+$", message = "The name of plate must have only letters")
    private String synopsis;
    @Pattern( regexp = "^(https?|ftp)://[^\s/$.?#].[^\s]*$", message = "The format of url is invalid")
    private String url;
}
