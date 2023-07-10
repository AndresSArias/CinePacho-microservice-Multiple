package com.pragma.powerup.usermicroservice.adapters.driving.http.endpoints.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.ScheduleRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ScheduleCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowAliveResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowScheduleResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IShowHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class ShowRestController {

    private final IShowHandler showHandler;

    @Operation(summary = "Show all schedules of movies in Cine Pacho")
    @GetMapping("/schedules/all")
    public ResponseEntity<List<ShowScheduleResponseDto>> getAllSchedule() {
        return ResponseEntity.ok(showHandler.getAllSchedule());
    }

    @Operation(summary = "Show all shows of movies in Cine Pacho by idMovie and idMultiplex")
    @GetMapping("/schedules/all/{idMovie}/{idMultiplex}")
    public ResponseEntity<List<ShowAliveResponseDto>> getAllShowByMovieAndMultiplex(@PathVariable("idMovie") String idMovie, @PathVariable("idMultiplex") String idMultiplex) {
        return ResponseEntity.ok(showHandler.getShowsByMovieAndMultiplex(idMovie,idMultiplex));
    }

    @Operation(summary = "Add a new schedule by Admin multiplex")
    @PostMapping("/schedules/new")
    public ResponseEntity<ScheduleCreateResponseDto> saveSchedule(@Valid @RequestBody ScheduleRequestDto scheduleRequestDto) {

        return ResponseEntity.ok(showHandler.saveSchedule(scheduleRequestDto));
    }
}
