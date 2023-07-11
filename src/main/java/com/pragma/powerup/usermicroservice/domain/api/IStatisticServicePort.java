package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.StatisticSaleResponseDto;

import java.util.List;

public interface IStatisticServicePort {

    List<StatisticSaleResponseDto> getStatisticSales ();
}
