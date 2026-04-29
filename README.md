# 🧩 API de Gerenciamento de Salas de Reunião - Checkpoint 2

## 📝 Descrição do Projeto
Esta API foi desenvolvida como parte do Checkpoint 2 da disciplina de Enterprise Application Development (FIAP). O objetivo é gerenciar o cadastro de salas de reunião e o agendamento de reservas, garantindo que não haja conflitos de horários.

O projeto segue os princípios da arquitetura **SOA (Service Oriented Architecture)**, com separação clara de responsabilidades em camadas (Controller, Service, Repository, DTO e Domain).

---

## 🚀 Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Security + JWT** (Autenticação Stateless)
- **Spring Data JPA**
- **H2 Database** (Banco de dados em memória)
- **Swagger/OpenAPI** (Documentação)
- **Maven** (Gerenciador de dependências)

---

## 🏗️ Arquitetura e Diferenciais Implementados
- **Arquitetura SOA:** Divisão em pacotes por função.
- **Tratamento Global de Exceções:** Implementado com `@RestControllerAdvice` para capturar erros de negócio.
- **Regras de Negócio:** Validação rigorosa para impedir reservas simultâneas na mesma sala.
- **Segurança:** Configuração de Spring Security preparada para JWT.
- **Diferenciais:** - ✅ Tratamento de Exceções customizado.
  - ✅ Validações de Datas (início deve ser antes do fim).
  - ✅ Logging estruturado.

---

## 🛠️ Como Executar o Projeto

1. Certifique-se de ter o **JDK 17** e o **Maven** instalados.
2. Clone o repositório:
   ```bash
   git clone [CP2_SOA]
Importe na sua IDE favorita (IntelliJ, Eclipse ou VS Code).

Execute a classe principal: Cp2SoaReservaDeSalaApplication.java.

A API estará disponível em: http://localhost:8080.

📖 Documentação (Swagger)
A documentação interativa dos endpoints pode ser acessada em:
👉 http://localhost:8080/swagger-ui.html

🧪 Exemplos de Requisições (Insomnia/Postman)
1. Criar Sala (POST)
URL: http://localhost:8080/salas<br>

JSON<Br>
{ <Br>
  "nome": "Sala Alpha", <br>
  "capacidade": 10, <br>
  "localizacao": "Bloco A - 2º Andar" <br>
} <br>
2. Listar Reservas (GET)<br>
URL: http://localhost:8080/reservas<br>

3. Criar Reserva (POST)<br>
URL: http://localhost:8080/reservas<br>

JSON<br>
{<br>
  "salaId": 1,<br>
  "dataHoraInicio": "2026-10-10T14:00:00",<br>
  "dataHoraFim": "2026-10-10T15:00:00",<br>
  "responsavel": "Gabriel"<br>
}<br>

👤 Autor
Nome: Gabriel Luni Nakashima

RM: RM558096

Turma: 3ESPZ

### 💡 Dicas finais para a entrega:
1. **GitHub:** Certifique-se de que o arquivo `.gitignore` está configurado para não subir as pastas `target` e arquivos da IDE (`.iml`, `.idea`).
2. **Commit:** Dê um commit com uma mensagem clara, ex: `feat: finaliza CRUD de reservas e regras de conflito`.
3. **Link:** Teste o link do GitHub antes de enviar no formulário/portal da FIAP.
