package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.*;
import com.pragma.powerup.usermicroservice.adapters.driving.http.exceptions.NoAllowedUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.pragma.powerup.usermicroservice.configuration.Constants.*;
import static com.pragma.powerup.usermicroservice.configuration.Constants.CLIENT_CANNOT_UPDATE_RAITING_MESSAGE;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            } else {
                errorMessages.add(error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(AuthenticationException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, WRONG_CREDENTIALS_MESSAGE));
    }

    @ExceptionHandler(NoAllowedUserException.class)
    public ResponseEntity<Map<String, String>> handleNoAllowedUserException(NoAllowedUserException noAllowedUserException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_ALLOWED_USER_MESSAGE));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_DATA_FOUND_MESSAGE));
    }

    @ExceptionHandler(MultiplexAlredyExistException.class)
    public ResponseEntity<Map<String, String>> handleMultiplexAlredyExistException(MultiplexAlredyExistException multiplexAlredyExistException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, MULTIPLEX_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(MovieAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleMovieAlredyExistException(MovieAlreadyExistException movieAlredyExistException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, MOVIE_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(NoMultiplexFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoMultiplexFoundException (NoMultiplexFoundException
                                                                                        noMultiplexFoundException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_MULTIPLEX_FOUND_MESSAGE));
    }

    @ExceptionHandler(NoTheatresEnoughException.class)
    public ResponseEntity<Map<String, String>> handleNoTheatresEnoughException (NoTheatresEnoughException
                                                                                        noTheatresEnoughException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_THEATRES_ENOUGH_MESSAGE));

    }

    @ExceptionHandler(NoMovieFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoMovieFoundException (NoMovieFoundException noMovieFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_MOVIE_FOUND_MESSAGE));
    }

    @ExceptionHandler(NoShowFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoShowFoundException (NoShowFoundException noShowFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_SHOW_FOUND_MESSAGE));
    }
    @ExceptionHandler(NoTheatreFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoTheatreFoundException (NoTheatreFoundException noTheatreFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_THEATER_FOUND_MESSAGE));
    }
    @ExceptionHandler(NoCreateShowException.class)
    public ResponseEntity<Map<String, String>> handleNoCreateShowException(NoCreateShowException noCreateShowException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_CREATE_SHOW_MESSAGE));
    }
    @ExceptionHandler(NoShowExistException.class)
    public ResponseEntity<Map<String, String>> handleNoShowExistException (NoShowExistException noShowExistException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_SHOW_EXIST_MESSAGE));
    }
    @ExceptionHandler(SelectChairReservedException.class)
    public ResponseEntity<Map<String, String>> handleSelectChairReservedException(SelectChairReservedException selectChairReservedException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, SELECT_CHAIR_RESERVED_MESSAGE));
    }
    @ExceptionHandler(InvoiceNoFoundException.class)
    public ResponseEntity<Map<String, String>> handleInvoiceNoFoundException (InvoiceNoFoundException invoiceNoFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NO_INVOICE_EXIST_MESSAGE));
    }
    @ExceptionHandler(ClientCannotUpdateRaitingException.class)
    public ResponseEntity<Map<String, String>> handleClientCannotUpdateRaitingException(
            ClientCannotUpdateRaitingException clientCannotUpdateRaitingException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CLIENT_CANNOT_UPDATE_RAITING_MESSAGE));
    }


}