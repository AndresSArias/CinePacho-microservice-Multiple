package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.Snack;

import java.util.List;

public interface ISnackPersistencePort {
    List<Snack> getAllSnacks ();

}
