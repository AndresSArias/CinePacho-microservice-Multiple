package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.ShowInvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShowInvoiceRepository extends JpaRepository<ShowInvoiceEntity, Long> {

}