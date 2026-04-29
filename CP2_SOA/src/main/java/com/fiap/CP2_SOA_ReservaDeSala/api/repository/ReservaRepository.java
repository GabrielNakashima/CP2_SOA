package com.fiap.CP2_SOA_ReservaDeSala.api.repository;

import com.fiap.CP2_SOA_ReservaDeSala.api.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    boolean existsBySalaIdAndDataHoraInicioBeforeAndDataHoraFimAfter(
            Long salaId,
            LocalDateTime fim,
            LocalDateTime inicio
    );
}