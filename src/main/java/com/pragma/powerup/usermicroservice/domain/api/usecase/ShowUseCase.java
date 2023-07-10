package com.pragma.powerup.usermicroservice.domain.api.usecase;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowAliveResponseDto;
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
}
