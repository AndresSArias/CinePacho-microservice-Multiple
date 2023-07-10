package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ScheduleRequestDto {

    @Pattern(regexp = "^[A-Za-zÁ-Úá-ú0-9 ]+$", message = "The name of movie must have only letters and numbers")
    private String movieName;

    @Pattern(regexp = "^[0-9]+$" , message = "The idTheater must have only numbers")
    private String idTheater;

    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[0-2])-\\d{4}$", message = "The day format is incorrect")
    private String day;

    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$", message = "The schedule format is incorrect")
    private String schedule;

}
