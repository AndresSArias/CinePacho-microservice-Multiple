package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.SnackResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.factory.mapper.response.ISnackResponseMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.ISnackHandler;
import com.pragma.powerup.usermicroservice.domain.api.ISnackServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SnackHandlerImpl implements ISnackHandler {
    private final ISnackServicePort snackServicePort;
    private final ISnackResponseMapper snackResponseMapper;
    @Override
    public List<SnackResponseDto> getAllSnacks() {
        return snackResponseMapper.toListDto(snackServicePort.getAllSnacks());
    }
}
