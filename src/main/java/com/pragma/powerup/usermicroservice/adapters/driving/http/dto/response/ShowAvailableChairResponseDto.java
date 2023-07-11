package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ShowAvailableChairResponseDto {
    private String idShow;
    private String chairGeneral;
    private String chairPreferential;
}
