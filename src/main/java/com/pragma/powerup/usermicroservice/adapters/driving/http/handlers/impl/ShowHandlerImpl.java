package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.ScheduleRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ObjectCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowAliveResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowScheduleResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IShowHandler;
import com.pragma.powerup.usermicroservice.domain.api.IShowServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ShowHandlerImpl implements IShowHandler {

    private final IShowServicePort showServicePort;

    @Override
    public List<ShowScheduleResponseDto> getAllSchedule() {
        return showServicePort.getAllShowSchedule();
    }

    @Override
    public List<ShowAliveResponseDto> getShowsByMovieAndMultiplex(String idMovie, String idMultiplex) {
        return showServicePort.getShowsByMovieAndMultiplex(idMovie, idMultiplex);
    }

    @Override
    public ObjectCreateResponseDto saveSchedule(ScheduleRequestDto scheduleRequestDto) {
        return showServicePort.saveSchedule( scheduleRequestDto);
    }
}
