package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.StatisticRaitingResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.StatisticSaleResponseDto;

import java.util.List;

public interface IStatisticPersistencePort {
    List<StatisticSaleResponseDto> getStatisticSales ();

    List<StatisticRaitingResponseDto> getStatisticRainting();
}
