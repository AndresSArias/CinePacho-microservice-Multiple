package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ShowScheduleResponseDto {
    private String id;
    private String movieName;
    private String idTheater;
    private String day;
    private String schedule;
}
