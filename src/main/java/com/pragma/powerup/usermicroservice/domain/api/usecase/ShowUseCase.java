package com.pragma.powerup.usermicroservice.domain.api.usecase;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.ScheduleRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ObjectCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowAliveResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowAvailableChairResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowScheduleResponseDto;
import com.pragma.powerup.usermicroservice.domain.api.IShowServicePort;
import com.pragma.powerup.usermicroservice.domain.spi.IShowPersistencePort;

import java.util.List;

public class ShowUseCase implements IShowServicePort {
    private final IShowPersistencePort showPersistencePort;

    public ShowUseCase(IShowPersistencePort showPersistencePort) {
        this.showPersistencePort = showPersistencePort;
    }

    @Override
    public List<ShowScheduleResponseDto> getAllShowSchedule() {
        return showPersistencePort.getAllShowSchedule();
    }

    @Override
    public List<ShowAliveResponseDto> getShowsByMovieAndMultiplex(String idMovie, String idMultiplex) {
        return showPersistencePort.getShowsByMovieAndMultiplex(idMovie, idMultiplex);
    }

    @Override
    public ObjectCreateResponseDto saveSchedule(ScheduleRequestDto scheduleRequestDto) {
        return showPersistencePort.saveSchedule (scheduleRequestDto);
    }

    @Override
    public ShowAvailableChairResponseDto getAvailableChair(String idMovie, String idMultiplex,String day, String schedule) {
        return showPersistencePort.getAvailableChair(idMovie,idMultiplex,day,schedule);
    }
}
