package com.fiap.CP2_SOA_ReservaDeSala;

import com.fiap.CP2_SOA_ReservaDeSala.api.domain.Sala;
import com.fiap.CP2_SOA_ReservaDeSala.api.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Cp2SoaReservaDeSalaApplication implements CommandLineRunner {

    @Autowired
    private SalaRepository salaRepository;

    public static void main(String[] args) {
        SpringApplication.run(Cp2SoaReservaDeSalaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        salaRepository.deleteAll();

        Sala s1 = new Sala(null, "Auditório Master", 150, "Bloco A - Térreo");
        Sala s2 = new Sala(null, "Laboratório 302", 40, "Bloco B - 3º Andar");
        Sala s3 = new Sala(null, "Sala de Mentorias", 06, "Bloco C - 1º Andar");

        salaRepository.saveAll(Arrays.asList(s1, s2, s3));
    }
}