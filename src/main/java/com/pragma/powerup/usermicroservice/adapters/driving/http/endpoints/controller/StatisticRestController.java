package com.pragma.powerup.usermicroservice.adapters.driving.http.endpoints.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowScheduleResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.StatisticRaitingResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.StatisticSaleResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IStatisticHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class StatisticRestController {
    private final IStatisticHandler statisticHandler;

    @Operation(summary = "Show statistic of sell total for multiplex")
    @GetMapping("/sales")
    public ResponseEntity<List<StatisticSaleResponseDto>> getStatisticSales() {
        return ResponseEntity.ok(statisticHandler.getStatisticSales());
    }

    @Operation(summary = "Show statistic average rating for movie")
    @GetMapping("/movie")
    public ResponseEntity<List<StatisticRaitingResponseDto>> getStatisticRainting() {
        return ResponseEntity.ok(statisticHandler.getStatisticRainting());
    }
}
