package com.pragma.powerup.usermicroservice.adapters.driving.http.endpoints.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.SnackResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.ISnackHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snacks")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class SnackRestController {
    private final ISnackHandler snackHandler;
    @Operation(summary = "Show all information of all snacks")
    @GetMapping("/all")
    public ResponseEntity<List<SnackResponseDto>> getAllSnacks() {
        return ResponseEntity.ok(snackHandler.getAllSnacks());
    }
}
