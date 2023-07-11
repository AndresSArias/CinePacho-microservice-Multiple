package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.StatisticSaleResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IStatisticHandler;
import com.pragma.powerup.usermicroservice.domain.api.IStatisticServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StatisticHandlerImpl implements IStatisticHandler {
    private final IStatisticServicePort statisticServicePort;
    @Override
    public List<StatisticSaleResponseDto> getStatisticSales() {
        return statisticServicePort.getStatisticSales();
    }
}
