package com.pragma.powerup.usermicroservice.adapters.driving.http.endpoints.controller;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.MultiplexMySqlAdapter;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.MultiplexRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MovieResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MultiplexPointsResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MultiplexResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.NewMultiplexResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IMultiplexHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.api.usecase.MultiplexUseCase;
import com.pragma.powerup.usermicroservice.domain.model.Multiplex;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
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

    @Operation(summary = "Show all Multiplex")
    @GetMapping("/all")
    public ResponseEntity<List<MultiplexResponseDto>> getAllMultiplex() {
        return ResponseEntity.ok(multiplexHandler.getAllMultiplex());
    }

    @Operation(summary = "Show points of Multiplex")
    @GetMapping("/points/{id_multiplex}")
    public ResponseEntity<MultiplexPointsResponseDto> getMultiplexPoints(@PathVariable("id_multiplex") Long idMultiplex) {
        return ResponseEntity.ok(multiplexHandler.getPointsMultiplex(idMultiplex));
    }

    @Operation(summary = "Change points of Multiplex")
    @PutMapping("/points/{id_multiplex}")
    public ResponseEntity<Map<String, String>>  updateMultiplexPoints(@PathVariable("id_multiplex") Long idMultiplex, @RequestBody MultiplexPointsResponseDto pointsUpdateDto) {
        multiplexHandler.setPointsMultiplex(idMultiplex,pointsUpdateDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.MULTIPLEX_POINTS_UPDATE));
    }

}
