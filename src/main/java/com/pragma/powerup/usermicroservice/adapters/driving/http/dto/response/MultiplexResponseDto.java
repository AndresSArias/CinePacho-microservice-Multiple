package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MultiplexResponseDto {
    private Long id;
    private String name;
    private int Num_sala;
    private int Point_ticket;
    private int Point_snack;
}
