package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IInvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
}
