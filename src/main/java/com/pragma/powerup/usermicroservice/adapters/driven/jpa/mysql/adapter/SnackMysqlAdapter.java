package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.ISnackEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.ISnackRepository;
import com.pragma.powerup.usermicroservice.domain.model.Snack;
import com.pragma.powerup.usermicroservice.domain.spi.ISnackPersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class SnackMysqlAdapter implements ISnackPersistencePort {
    private final ISnackRepository snackRepository;
    private final ISnackEntityMapper snackEntityMapper;

    @Override
    public List<Snack> getAllSnacks() {
        return snackEntityMapper.toListModel(snackRepository.findAll());
    }
}
