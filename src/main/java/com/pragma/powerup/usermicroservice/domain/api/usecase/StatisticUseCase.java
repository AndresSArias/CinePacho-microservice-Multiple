package com.pragma.powerup.usermicroservice.domain.api.usecase;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.StatisticSaleResponseDto;
import com.pragma.powerup.usermicroservice.domain.api.IStatisticServicePort;
import com.pragma.powerup.usermicroservice.domain.spi.IStatisticPersistencePort;

import java.util.List;

public class StatisticUseCase implements IStatisticServicePort {

    private final IStatisticPersistencePort statisticPersistnecePort;

    public StatisticUseCase(IStatisticPersistencePort statisticPersistnecePort) {
        this.statisticPersistnecePort = statisticPersistnecePort;
    }

    @Override
    public List<StatisticSaleResponseDto> getStatisticSales() {
        return statisticPersistnecePort.getStatisticSales();
    }
}
