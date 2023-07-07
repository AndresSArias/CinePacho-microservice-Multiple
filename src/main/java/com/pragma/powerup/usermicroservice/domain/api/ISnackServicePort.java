package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.Snack;

import java.util.List;

public interface ISnackServicePort {
    List<Snack> getAllSnacks();

}
