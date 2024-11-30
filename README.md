# Projeto Detran - Receptor de Fila RabbitMQ

Este projeto é o receptor da fila RabbitMQ, responsável por gerenciar as requisições para remoção de multas do Detran e executar as deleções no banco de dados.

## 🛠 Tecnologias Utilizadas

| Tecnologia      | Descrição                                           |
|-----------------|-----------------------------------------------------|
| 🐇 RabbitMQ     | Sistema de mensageria usado para gerenciar as filas de requisições. |
| 💻 Java         | Linguagem de programação usada para implementar o receptor. |
| 🧩 Spring Boot  | Framework utilizado para construir a aplicação backend. |
| 🗃 MySQL        | Banco de dados relacional usado para armazenar as multas. |
| 🔄 Hibernate    | Framework ORM para mapear as entidades Java para o MySQL. |
| 🐳 Docker       | Contêinerização da aplicação para facilitar a implantação. |
| 🏗 Jenkins      | Integração contínua e automação de builds. |

## ⚙ Funcionalidades

- 📥 **Recebimento de Mensagens:** Consome mensagens da fila RabbitMQ, contendo dados das multas a serem removidas.
- 🗑 **Remoção de Multas:** Processa e executa as deleções de multas no banco de dados.
- 🔄 **Gerenciamento de Erros:** Log de erros em caso de falha na remoção ou na comunicação com a fila.
- ⏳ **Fila de Requisições:** As requisições para remoção de multas são processadas na ordem em que chegam.
