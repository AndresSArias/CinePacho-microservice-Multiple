package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowScheduleResponseDto;

import java.util.List;

public interface IShowServicePort {

    List<ShowScheduleResponseDto> getAllShowSchedule();
}
