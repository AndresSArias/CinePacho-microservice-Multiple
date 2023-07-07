package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.SnackResponseDto;

import java.util.List;

public interface ISnackHandler {

    List<SnackResponseDto> getAllSnacks ();
}
