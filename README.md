# despesas-backend

Proyecto BackEnd  que permite gerencias as despesas e gerar os dados dos relatorios.

### Requisitos Iniciales

| Herramienta | Version |
|:------------|:--------|
| Java        | 17.0.2  |
| Maven       | 3.8.1   |
| Spring Boot | 3.3.2   |
| Lombok      | 1.18.x  |

- Configurar Java, Maven y Lombok na rota local.
- Configurar o IDE do desenvolvimento

### Contexto do serviço

- /v1/desafio

### URL base del servicio

| Entorno      | URL base                          |
|:-------------|:----------------------------------|
|Desarrollo    | http://localhost:8081/v1/desafio  |
|Test          | http://localhost:8081/v1/desafio  |
|Produccion    | http://localhost:8081/v1/desafio  |

### Detalle del servicio

| Endpoint                    | Descripción                          |
|:----------------------------|:-------------------------------------|
| (GET) /movimentacoes        | Lista de movimentações de despesas   |
| (GET) /relatorios/mes       | Relatorio das despesas por mês       |
| (GET) /relatorios/categoria | Relatorio das despesas por categoria |
| (GET) /relatorios/fontes    | Relatorio das despesas por fonte     |

### Banco de dados

| Entorno   | Banco                | Rota de acesso                       |
|:----------|:---------------------|:-------------------------------------|
| Local     | h2                   | localhost:8081/v1/desafio/h2-console |
| Local     | username             | sa                                   |
| Local     | password             |                                      |


### Documentação API

| Entorno   | Libreria | Rota de acesso                                         |
|:----------|:---------|:-------------------------------------------------------|
| Local     | Swagger  | http://localhost:8081/v1/desafio/swagger-ui/index.html |
|     