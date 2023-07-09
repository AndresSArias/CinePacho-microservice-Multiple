package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowScheduleResponseDto;

import java.util.List;

public interface IShowHandler {

    List<ShowScheduleResponseDto> getAllSchedule ();
}
