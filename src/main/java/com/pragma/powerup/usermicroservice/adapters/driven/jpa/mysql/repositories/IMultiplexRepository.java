package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMultiplexRepository extends JpaRepository<MultiplexEntity,Long> {
}