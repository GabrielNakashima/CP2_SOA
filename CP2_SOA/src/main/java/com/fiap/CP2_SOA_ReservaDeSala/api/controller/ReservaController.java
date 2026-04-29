package com.fiap.CP2_SOA_ReservaDeSala.api.controller;

import com.fiap.CP2_SOA_ReservaDeSala.api.domain.Reserva;
import com.fiap.CP2_SOA_ReservaDeSala.api.dto.CriarReservaDTO;
import com.fiap.CP2_SOA_ReservaDeSala.api.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // CRIAR (POST)
    @PostMapping
    @Transactional
    public ResponseEntity<Reserva> cadastrar(@RequestBody @Valid CriarReservaDTO dto) {
        // Chamando o método 'salvar' conforme definimos no seu Service
        var reserva = reservaService.salvar(dto);
        return ResponseEntity.ok(reserva);
    }

    // LISTAR (GET)
    @GetMapping
    public ResponseEntity<List<Reserva>> listar() {
        var reservas = reservaService.listarTodas(); // Certifique-se de ter este método no Service ou use o repository diretamente
        return ResponseEntity.ok(reservas);
    }

    // ALTERAR (PUT)
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Reserva> atualizar(@PathVariable Long id, @RequestBody @Valid CriarReservaDTO dto) {
        var reserva = reservaService.atualizar(id, dto);
        return ResponseEntity.ok(reserva);
    }

    // EXCLUIR (DELETE)
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        reservaService.cancelar(id);
        return ResponseEntity.noContent().build();
    }
}