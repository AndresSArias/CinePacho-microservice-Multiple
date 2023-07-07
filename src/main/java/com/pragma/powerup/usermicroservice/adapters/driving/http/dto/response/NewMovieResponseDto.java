package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NewMovieResponseDto {
    private String title;
    private String duration;
    private String yearAllowed;
    private String synopsis;
    private String url;
}
