package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MovieResponseDto {
    private String id;
    private String title;
    private String duration;
    private String yearAllowed;
    private String synopsis;
    private String url;
}
