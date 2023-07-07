package com.pragma.powerup.usermicroservice.adapters.driving.http.endpoints.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.MultiplexRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MultiplexHCIPage;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.NewMultiplexResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IMultiplexHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/multiplex")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class MultiplexRestController {
    private final IMultiplexHandler multiplexHandler;

    @PostMapping("/new")
    public ResponseEntity<NewMultiplexResponseDto> saveMultiplex (@Valid @RequestBody MultiplexRequestDto multiplexRequestDto) {
        return ResponseEntity.ok(multiplexHandler.saveMultiplex(multiplexRequestDto));
    }

    @GetMapping("/all")
    @Operation(summary = "Get all the Multiplex")
    public ResponseEntity<MultiplexHCIPage> getAllMultiplexes(@PathVariable int size, @PathVariable int page) {
        return ResponseEntity.ok(multiplexHandler.getAllMultiplexes(page,size));
    }
}
