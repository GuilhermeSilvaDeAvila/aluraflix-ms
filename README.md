# aluraflix-ms
Microserviço criado através do Alura Challange Backend Primeira Edição

## Tecnologias

- H2 Database;
- Lombok
- Maven;
- Modell Mapper;
- Java;
- Spring Boot;
- Spring Data JPA;

## Resumo
API projetada para realizar o gerencimaneto de registros de um catálogo de vídeos.

### Funcionalidades

- Registro de um vídeo
- Atualização dos dados de um vídeo
- Busca de um vídeo por ID
- Listar todos os vídeos registrados
- Remoção de um vídeo através do ID

## Acesso aos recursos da API
Para acessar os recursos da api é necessário realizar o envio das requisições para a url base *http://localhost:8080*, seguem abaixo os métodos de acesso
aos recursos da API.

| Verbo HTTP |      Resource path     |     Descrição      |
|:-----------|:-----------------------|:-------------------|
|    POST    | /video                 | Criar video        |
|    PUT     | /video/{id}            | Atualizar video    |
|    GET     | /video                 | Listar todos videos|
|    GET     | /video{id}             | Busca video por ID |
|  DELETE    | /video/{id}            | Deletar video      |
