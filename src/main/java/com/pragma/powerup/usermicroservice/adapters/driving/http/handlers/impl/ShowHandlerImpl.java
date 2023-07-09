package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

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
}
