package com.pragma.powerup.usermicroservice.adapters.driving.http.endpoints.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MovieResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IMovieHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class MovieRestController {
    private final IMovieHandler movieHandler;

    @Operation(summary = "Show all information of all movies")
    @GetMapping("/all")
    public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
        return ResponseEntity.ok(movieHandler.getAllMovies());
    }
}
