package com.fiap.CP2_SOA_ReservaDeSala.api.controller;

import com.fiap.CP2_SOA_ReservaDeSala.api.domain.Sala;
import com.fiap.CP2_SOA_ReservaDeSala.api.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaRepository repository;

    // LISTAR SALAS
    @GetMapping
    public ResponseEntity<List<Sala>> listar() {
        var salas = repository.findAll();
        return ResponseEntity.ok(salas);
    }

    // CRIAR SALA
    @PostMapping
    public ResponseEntity<Sala> criar(@RequestBody Sala sala) {
        var salaSalva = repository.save(sala);
        return ResponseEntity.ok(salaSalva);
    }
    // ALTERAR SALA
    @PutMapping("/{id}")
    public ResponseEntity<Sala> atualizarSala(@PathVariable Long id, @RequestBody Sala salaAtualizada) {
        return repository.findById(id)
                .map(sala -> {
                    sala.setNome(salaAtualizada.getNome());
                    sala.setCapacidade(salaAtualizada.getCapacidade());
                    sala.setLocalizacao(salaAtualizada.getLocalizacao());
                    Sala salva = repository.save(sala);
                    return ResponseEntity.ok(salva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // EXCLUIR SALA
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirSala(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 (Sucesso sem corpo)
    }
}