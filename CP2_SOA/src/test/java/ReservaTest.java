import com.fiap.CP2_SOA_ReservaDeSala.api.dto.CriarReservaDTO;
import com.fiap.CP2_SOA_ReservaDeSala.api.service.ReservaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ReservaTest {

	@Autowired
	private ReservaService reservaService;

	@Test
	public void naoDevePermitirDataInicioMaiorQueFim() {
		CriarReservaDTO dto = new CriarReservaDTO(
				1L,
				LocalDateTime.of(2025, 10, 10, 15, 0), // Início às 15h
				LocalDateTime.of(2025, 10, 10, 14, 0), // Fim às 14h (Inválido)
				"João"
		);

		assertThrows(IllegalArgumentException.class, () -> {
			reservaService.criarReserva(dto);
		});
	}
}