package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.StatisticSaleResponseDto;

import java.util.List;

public interface IStatisticHandler {

    List<StatisticSaleResponseDto> getStatisticSales ();

}
