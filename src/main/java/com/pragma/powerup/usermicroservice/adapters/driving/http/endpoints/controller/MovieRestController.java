package com.pragma.powerup.usermicroservice.adapters.driving.http.endpoints.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.MovieRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MovieResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.NewMovieResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IMovieHandler;
import com.pragma.powerup.usermicroservice.domain.model.Movie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class MovieRestController {
    private final IMovieHandler movieHandler;
@PostMapping("/new")
public ResponseEntity <NewMovieResponseDto> saveMovie(@Valid @RequestBody MovieRequestDto movieRequestDto){
    return ResponseEntity.ok(movieHandler.saveMovie(movieRequestDto));
}

    @Operation(summary = "Show all information of all movies")
    @GetMapping("/all")
    public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
        return ResponseEntity.ok(movieHandler.getAllMovies());
    }
}
