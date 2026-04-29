package com.fiap.CP2_SOA_ReservaDeSala.api.service;

import com.fiap.CP2_SOA_ReservaDeSala.api.domain.Reserva;
import com.fiap.CP2_SOA_ReservaDeSala.api.dto.CriarReservaDTO;
import com.fiap.CP2_SOA_ReservaDeSala.api.repository.ReservaRepository;
import com.fiap.CP2_SOA_ReservaDeSala.api.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private SalaRepository salaRepository;

    public Reserva salvar(CriarReservaDTO dto) {
        validarConflito(dto.getSalaId(), dto.getDataHoraInicio(), dto.getDataHoraFim(), null);

        Reserva reserva = new Reserva();
        reserva.setSala(salaRepository.findById(dto.getSalaId()).orElseThrow());
        reserva.setDataHoraInicio(dto.getDataHoraInicio());
        reserva.setDataHoraFim(dto.getDataHoraFim());
        reserva.setResponsavel(dto.getResponsavel());

        return reservaRepository.save(reserva);
    }
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }
    public Reserva atualizar(Long id, CriarReservaDTO dto) {
        Reserva reservaExistente = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));

        validarConflito(dto.getSalaId(), dto.getDataHoraInicio(), dto.getDataHoraFim(), id);

        reservaExistente.setDataHoraInicio(dto.getDataHoraInicio());
        reservaExistente.setDataHoraFim(dto.getDataHoraFim());
        reservaExistente.setResponsavel(dto.getResponsavel());

        return reservaRepository.save(reservaExistente);
    }

    public void cancelar(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível excluir: Reserva não encontrada.");
        }
        reservaRepository.deleteById(id);
    }

    private void validarConflito(Long salaId, LocalDateTime inicio, LocalDateTime fim, Long reservaId) {
        if (fim.isBefore(inicio)) {
            throw new RuntimeException("A data de fim não pode ser anterior à data de início.");
        }

        boolean conflito = reservaRepository.existsBySalaIdAndDataHoraInicioBeforeAndDataHoraFimAfter(
                salaId, fim, inicio);

        if (conflito) {
            throw new RuntimeException("Conflito de horário: Esta sala já está reservada neste período.");
        }
    }

}