package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.ScheduleRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ObjectCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowAliveResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowAvailableChairResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowScheduleResponseDto;

import java.util.List;

public interface IShowServicePort {

    List<ShowScheduleResponseDto> getAllShowSchedule();

    List<ShowAliveResponseDto> getShowsByMovieAndMultiplex (String idMovie, String idMultiplex);

    ObjectCreateResponseDto saveSchedule (ScheduleRequestDto scheduleRequestDto);

    ShowAvailableChairResponseDto getAvailableChair (String idMovie, String idMultiplex, String day,String schedule);
}
