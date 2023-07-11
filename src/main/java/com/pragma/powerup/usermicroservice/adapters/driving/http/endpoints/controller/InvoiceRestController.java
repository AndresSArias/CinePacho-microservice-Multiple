package com.pragma.powerup.usermicroservice.adapters.driving.http.endpoints.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.InvoiceCompleteRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.ScheduleRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ObjectCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.QualificationRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IInvoiceHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class InvoiceRestController {

    private final IInvoiceHandler invoiceHandler;

    @Operation(summary = "Create a new invoice of buy client by employee")
    @PostMapping("/new")
    public ResponseEntity<ObjectCreateResponseDto> saveSchedule(@Valid @RequestBody InvoiceCompleteRequestDto invoiceCompleteRequestDto) {

        return ResponseEntity.ok(invoiceHandler.saveCompleteInvoice(invoiceCompleteRequestDto));
    }

    @Operation(summary = "Update rating of viewed movie Cine Pacho by Client")
    @PutMapping("/qualification/movie")
    public ResponseEntity<Map<String, String>> updateRating (@Valid @RequestBody QualificationRequestDto qualificationRequestDto) {
        invoiceHandler.updateRating(qualificationRequestDto);
        return ResponseEntity.ok().body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.RAITING_MOVIE_UPDATED_MESSAGE));
    }

}
