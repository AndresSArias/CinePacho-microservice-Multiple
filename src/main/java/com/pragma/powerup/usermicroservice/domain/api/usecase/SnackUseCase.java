package com.pragma.powerup.usermicroservice.domain.api.usecase;

import com.pragma.powerup.usermicroservice.domain.api.ISnackServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Snack;
import com.pragma.powerup.usermicroservice.domain.spi.ISnackPersistencePort;

import java.util.List;

public class SnackUseCase implements ISnackServicePort{
    private final ISnackPersistencePort snackPersistencePort;

    public SnackUseCase(ISnackPersistencePort snackPersistencePort) {
        this.snackPersistencePort = snackPersistencePort;
    }

    @Override
    public List<Snack> getAllSnacks() {
        return snackPersistencePort.getAllSnacks();
    }
}
