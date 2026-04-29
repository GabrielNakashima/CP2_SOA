package com.fiap.CP2_SOA_ReservaDeSala.api.repository;

import com.fiap.CP2_SOA_ReservaDeSala.api.domain.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}