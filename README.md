# API de Gerenciamento de Salas de Reunião - Checkpoint 2
## Descrição do Projeto
Esta API foi desenvolvida como parte do Checkpoint 2 da disciplina de Enterprise Application Development (FIAP). O objetivo é gerenciar o cadastro de salas de reunião e o agendamento de reservas, garantindo que não haja conflitos de horários.

O projeto segue os princípios da arquitetura SOA (Service Oriented Architecture), com separação clara de responsabilidades em camadas (Controller, Service, Repository, DTO e Domain).

### Tecnologias Utilizadas
Java 17+

Spring Boot 3.x

Spring Data JPA

H2 Database (Banco de dados em memória com carga inicial automática)

Jakarta Validation (Validação de dados)

Maven (Gerenciador de dependências)

## Arquitetura e Diferenciais Implementados
Arquitetura SOA: Divisão em pacotes por função (Controller, Service, Repository).

Tratamento Global de Exceções: Implementado com @RestControllerAdvice para capturar erros de negócio.

Regras de Negócio: Validação rigorosa para impedir reservas simultâneas na mesma sala.

Carga de Dados Inicial: A API já inicia populada com 3 salas de exemplo para facilitar os testes.

### Diferenciais:


✅ CRUD completo (Post, Get, Put, Delete) para Salas e Reservas.


✅ Validações de Datas (início deve ser antes do fim).


✅ Persistência em H2 com reset automático a cada execução.

## Como Executar o Projeto
Certifique-se de ter o JDK 17 e o Maven instalados.

Clone o repositório:

Bash<br>
git clone https://github.com/GabrielNakashima/CP2_SOA.git<br>
Importe na sua IDE favorita (IntelliJ, Eclipse ou VS Code).<br>

Execute a classe principal: Cp2SoaReservaDeSalaApplication.java<br>

A API estará disponível em: http://localhost:8080.

## Exemplos de Requisições (Postman)
Listar Salas (GET) - Já vêm pré-carregadas


URL: http://localhost:8080/salas


Criar Sala (POST)


URL: http://localhost:8080/salas


JSON
{ 
"nome": "Sala Alpha",


"capacidade": 10,


"localizacao": "Bloco A - 2º Andar"


}


Criar Reserva (POST)


URL: http://localhost:8080/reservas


JSON


{


"salaId": 1,


"dataHoraInicio": "2026-10-10T14:00:00",


"dataHoraFim": "2026-10-10T15:00:00",


"responsavel": "Gabriel"


}


Atualizar Reserva (PUT)


URL: http://localhost:8080/reservas/1


Deletar Reserva (DELETE)


URL: http://localhost:8080/reservas/1

## Autor
Nome: Gabriel Luni Nakashima

RM: RM558096

Turma: 3ESPZ
