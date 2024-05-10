# API-Project-DioBootcamp
Desenvolvimento de uma API simples rest/restful com Java 22 e Springboot. Projeto final do bootcamp Santander trilha backend com Java, na plataforma Dio

### Contexto
É uma API para consultas de dívidas relacionadas a um determinado cliente ou clientes.
````mermaid
classDiagram
    class Cliente {
        <<Entity>>
        +Long id
        +String nome
        +String endereco
        +String telefone
        +String email
    }

    class Dividas {
        <<Entity>>
        +int id
        +float valor
        +String status
        +Date dataVencimento
    }

    Cliente "1" -- "n" Dividas : possui
````

Foi utilizado o Postman para teste da API.
