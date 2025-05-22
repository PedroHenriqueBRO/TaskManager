📌 Projeto: Task Manager API
Esta é uma API REST desenvolvida com Spring Boot, cujo objetivo é permitir o cadastro e login de usuários, além do gerenciamento de tarefas pessoais associadas a cada usuário. O projeto visa implementar autenticação com JWT e utilizar Spring Security para proteger as rotas. Todo o sistema é persistido em um banco de dados PostgreSQL, com documentação da API gerada via Swagger e containerização utilizando Docker.

⚠️ Status: Projeto em desenvolvimento

🔧 Funcionalidades
✅ Cadastro de novos usuários com validação.

✅ Login com autenticação via DTO.

✅ Criação, listagem, atualização e exclusão de tarefas por usuário autenticado.

❌ Proteção de endpoints com Spring Security (security/ ainda não implementado).

✅ Integração com banco de dados PostgreSQL.

✅ Mapeamento entre entidades e DTOs.

❌ Tratamento global de exceções (exception/ ainda não implementado).

❌ Configuração geral da aplicação (config/ ainda não implementado).

❌ Projeto ainda não containerizado com Docker.

🛠️ Tecnologias Utilizadas
Java 17

Spring Boot

Spring Data JPA

PostgreSQL

Swagger/OpenAPI

❌ Spring Security (em andamento)

❌ JWT (em andamento)

❌ Docker (não implementado)
