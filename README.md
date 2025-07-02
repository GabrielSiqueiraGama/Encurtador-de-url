# Encurtador de URL

Um encurtador de URL simples utilizando **Java 21**, **Spring Boot** e **MongoDB (via Docker)**.

## Tecnologias

- Java 21
- Spring Boot
- MongoDB
- Docker
- Spring Data MongoDB


## API

### Encurtar uma URL

**POST** `/shorten-url`

#### 🔸 Requisição

```json
{
  "url": "https://www.exemplo.com"
}
```

#### 🔹 Resposta

```json
{
  "shortUrl": "http://localhost:8080/abc123"
}
```

---

### Redirecionar pela URL curta

**GET** `/{id}`

Exemplo:

```http
GET http://localhost:8080/abc123
```

Resposta: redirecionamento (HTTP 302) para a URL original.

---

## ⚙️ Configuração

Arquivo: `src/main/resources/application.properties`

```properties
spring.application.name=reduzurl

spring.data.mongodb.authentication-database=admin
spring.data.mongodb.auto-index-creation=true
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=reduzurldb
spring.data.mongodb.username=admin
spring.data.mongodb.password=123
```

---

## ⏳ Observação

As URLs encurtadas expiram **1 minuto** após a criação (definido no controller).

---

Desenvolvido com 💻 por [GabrielSiqueiraGama](https://github.com/GabrielSiqueiraGama) (zhant)
